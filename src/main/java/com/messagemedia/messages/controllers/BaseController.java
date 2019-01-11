/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.controllers;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.messagemedia.messages.Configuration;
import com.messagemedia.messages.exceptions.*;
import com.messagemedia.messages.http.client.HttpClient;
import com.messagemedia.messages.http.client.HttpContext;
import com.messagemedia.messages.http.client.HttpCallBack;
import com.messagemedia.messages.http.client.OkClient;
import com.messagemedia.messages.http.request.HttpRequest;
import com.messagemedia.messages.http.response.HttpResponse;
import com.messagemedia.messages.http.response.HttpStringResponse;

public abstract class BaseController {
	
	/**
	 * Public constant for our SDK version to send to the API.
	 */
	public static final String MESSAGE_MEDIA_JAVA_SDK_VERSION = "messagemedia-messages-java-sdk-1.2.0";
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    /**
     * Private variable to keep shared reference of client instance
     */
    private static HttpClient clientInstance = null;
    private static final Object syncObject = new Object();

    /**
     * Protected variable to keep reference of httpCallBack instance if user provides any
     */
    protected HttpCallBack httpCallBack = null;
    
    /**
     * Get httpCallBack associated with this controller
     * @return HttpCallBack
     */
    public HttpCallBack getHttpCallBack() {
        return httpCallBack;
    }
    
    /**
     * Set the httpCallBack for this controller
     * @param httpCallBack
     */
    public void setHttpCallBack(HttpCallBack httpCallBack) {
        this.httpCallBack = httpCallBack;
    }

    /**
     * Shared instance of the Http client
     * @return The shared instance of the http client 
     */
    public static HttpClient getClientInstance() {
        if (null == clientInstance) {
            synchronized (syncObject) {
                if (null == clientInstance) {
                    clientInstance = OkClient.getSharedInstance();
                }
            }
        }
        return clientInstance;
    }

    /**
     * Shared instance of the Http client
     * @param    client    The shared instance of the http client 
     */
    public static void setClientInstance(HttpClient client) {
        if (null != client) {
            synchronized (syncObject) {
                if (null != client) {
                    clientInstance = client;
                }
            }
        }
    }

    
    /**
     * Creates a request and applies the authentication to it.
     * 
     * @param queryUrl The url of the request (e.g.: https://api.messagemedia.com/v1/replies)
     * @param headers The headers of the request
     * 
     * @return HttpRequest The HttpRequest with proper validation headers
     *  
     * @throws JsonProcessingException In the case of malformed JSON
     * @throws APIException  If any error was encountered while applying the authentication
     */
    protected HttpRequest createRequestWithAuthentication(
    		String queryUrl, 
    		Map<String, String>  headers
	) throws 
    		JsonProcessingException, 
    		APIException
    {
    	return createRequestWithAuthentication(queryUrl, headers, null);
    }
    
    /**
     * Creates a request and applies the authentication to it.
     * 
     * @param queryUrl The url of the request (e.g.: https://api.messagemedia.com/v1/replies)
     * @param headers The headers of the request
     * @param body The (optional) body of the request
     * 
     * @return HttpRequest The HttpRequest with proper validation headers
     *  
     * @throws JsonProcessingException
     * @throws APIException 
     */
    protected HttpRequest createRequestWithAuthentication(
    		String queryUrl, 
    		Map<String, String>  headers, 
    		String body
	) throws 
    		JsonProcessingException, 
    		APIException
    {
    	if(hmacIsConfigured())
    	{
    		addHmacHeaderTo(headers, queryUrl, body);
    		
    		if(body == null)
    			return getClientInstance().get(queryUrl, headers, null);
    		else
    			return getClientInstance().postBody(queryUrl, headers, body);
    	}
    	else
    	{
    		if(body == null)
    			return getClientInstance().get(queryUrl, headers, null, Configuration.basicAuthUserName, Configuration.basicAuthPassword);
    		else
    			return getClientInstance().postBody(queryUrl, headers, body, Configuration.basicAuthUserName, Configuration.basicAuthPassword);
    	}

    }
    
    /**
     * Adds our account header key/value pair to the request headers.
     * 
     * @param headers The request headers
     * @param accountHeaderValue The account value
     */
    protected void addAccountHeaderTo(
    		Map<String, String> headers, 
    		String accountHeaderValue) 
    {
    	if(accountHeaderValue == null || accountHeaderValue.isEmpty())
    	{
    		return;
    	}
    	
    	headers.put("Account", accountHeaderValue);
    }
    
    
    /**
     * Validates the response against HTTP errors defined at the API level
     * @param   response    The response recieved
     * @param   context     Context of the request and the recieved response 
     */
    protected void validateResponse(HttpResponse response, HttpContext context) 
         throws APIException {
    	//get response status code to validate
    	int responseCode = response.getStatusCode();
    	if (responseCode == 400)
    		throw new APIException("Request was invalid", context);

    	if (responseCode == 404)
    		throw new APIException("Message not found", context);

    	if ((responseCode < 200) || (responseCode > 208)) //[200,208] = HTTP OK
    		throw new APIException("HTTP Response Not OK", context);
    }
    
    
    String getRFC7231DateTime() 
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
            "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }

    private void addHmacHeaderTo(
    		Map<String, String> headers, 
    		String url, 
    		String body
	) throws APIException 
    {
		if(!hmacIsConfigured())
		{
			return;
		}

    	try
		{
			String dateHeader = getRFC7231DateTime();
			String contentHash = "";
			String contentSignature = "";
	
			if(body != null)
			{
				contentHash = getMd5HashFor(body);
				contentSignature = "x-Content-MD5: " + contentHash + "\n";
			}
	
			headers.put("date", dateHeader);
	
			if(contentHash != null && !contentHash.isEmpty())
			{
				headers.put("x-Content-MD5", contentHash);
				//headers.put("content-length", body.Length.ToString());
			}
	
			String signature = createHmacEncodedSignatureFrom(dateHeader, contentSignature, body, url, headers);
			String authorizationHeader = "hmac username=\"" + Configuration.hmacAuthUserName + "\", algorithm=\"hmac-sha1\", headers=\"date" +
			(body != null ? " x-Content-MD5" : "") +" request-line\", signature=\"" + signature + "\"";
			
			headers.put("Authorization", authorizationHeader);
		}
    	catch(NoSuchAlgorithmException e)
    	{
    		throw new APIException("Could not find the MD5 algorithm. Check machine configuration");
    	} catch (UnsupportedEncodingException e) {
			throw new APIException("Could not find UTF-8 encoding. Check machine configuration");
		} catch (InvalidKeyException e) {
			throw new APIException("Invalid HMAC authorization key. Check machine configuration");
		}
    }
    
    private String getMd5HashFor(
    		String body
	) throws
    		UnsupportedEncodingException, 
    		NoSuchAlgorithmException 
    {
		byte[] messageBytes = body.getBytes("UTF-8");
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] md5Bytes = md5.digest(messageBytes);
		
		return toHexString(md5Bytes);
	}

    static String toHexString(byte[] bytes) 
    {
		Formatter formatter = new Formatter();
		
		for (byte b : bytes) {
			formatter.format("%02x", b);
		}

		String hexString = formatter.toString();
		formatter.close();
		
		return hexString;
	}

    private String createHmacEncodedSignatureFrom(
			String dateHeader, 
			String contentSignature, 
			String body, String url, 
			Map<String, String> headers
	) throws 
			InvalidKeyException,
			NoSuchAlgorithmException, 
			UnsupportedEncodingException
    {
		String signingString = "date: " + dateHeader + "\n" + contentSignature + ((body != null && !body.isEmpty()) ? "POST " : "GET ") + url.replace(Configuration.baseUri, "") + " HTTP/1.1";

		return getHmacEncodingFor(signingString);
    }
    
    /**
     * Checks if HMAC authentication is configured.
     * 
     * @return True if it is, False otherwise.
     */
    private boolean hmacIsConfigured()
    {
    	return Configuration.hmacAuthUserName != null && !Configuration.hmacAuthUserName.isEmpty() && 
    	   		   Configuration.hmacAuthPassword != null && !Configuration.hmacAuthPassword.isEmpty();
    }
    
    private String getHmacEncodingFor(
    		String signature
	) throws 
    		NoSuchAlgorithmException, 
    		InvalidKeyException, UnsupportedEncodingException 
    {
	    Mac hasher = Mac.getInstance(HMAC_SHA1_ALGORITHM);
	    hasher.init(new SecretKeySpec(Configuration.hmacAuthPassword.getBytes(), HMAC_SHA1_ALGORITHM));

	    byte[] hash = hasher.doFinal(signature.getBytes());

	    String base64Encoded = Base64.getEncoder().encodeToString(hash);

	    return base64Encoded;
      }
}
