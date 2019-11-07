package com.messagemedia.messages;

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
import com.messagemedia.messages.exceptions.APIException;

public class AuthManager {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    /**
     * Apply authentication by adding auth headers.
     * 
     * @param queryUrl The url of the request (e.g.:
     *                 https://api.messagemedia.com/v1/replies)
     * @param headers  The headers of the request
     * 
     * @return HttpRequest The HttpRequest with proper validation headers
     * 
     * @throws JsonProcessingException In the case of malformed JSON
     * @throws APIException            If any error was encountered while applying
     *                                 the authentication
     */
    public static void apply(String queryUrl, Map<String, String> headers)
            throws JsonProcessingException, APIException {
        apply(queryUrl, headers, null);
    }

    /**
     * Apply authentication by adding auth headers.
     * 
     * @param queryUrl The url of the request (e.g.:
     *                 https://api.messagemedia.com/v1/replies)
     * @param headers  The headers of the request
     * @param body     The (optional) body of the request
     * 
     * @return HttpRequest The HttpRequest with proper validation headers
     * 
     * @throws JsonProcessingException
     * @throws APIException
     */
    public static void apply(String queryUrl, Map<String, String> headers, String body)
            throws JsonProcessingException, APIException {
        if (hmacIsConfigured()) {
            addHmacHeaderTo(headers, queryUrl, body);
        } else {
            headers.put("Authorization", getBasicAuthForClient());
        }
    }

    /**
     * Build authorization header value for basic auth
     * 
     * @return Authorization header value for this client
     */
    private static String getBasicAuthForClient() {
        String val = Configuration.basicAuthUserName + ":" + Configuration.basicAuthPassword;
        return "Basic " + new String(Base64.getEncoder().encode(val.getBytes()));
    }

    private static String getRFC7231DateTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }

    private static void addHmacHeaderTo(Map<String, String> headers, String url, String body) throws APIException {
        if (!hmacIsConfigured()) {
            return;
        }

        try {
            String dateHeader = getRFC7231DateTime();
            String contentHash = "";
            String contentSignature = "";

            if (body != null) {
                contentHash = getMd5HashFor(body);
                contentSignature = "x-Content-MD5: " + contentHash + "\n";
            }

            headers.put("date", dateHeader);

            if (contentHash != null && !contentHash.isEmpty()) {
                headers.put("x-Content-MD5", contentHash);
            }

            String signature = createHmacEncodedSignatureFrom(dateHeader, contentSignature, body, url, headers);
            String authorizationHeader = "hmac username=\"" + Configuration.hmacAuthUserName
                    + "\", algorithm=\"hmac-sha1\", headers=\"date" + (body != null ? " x-Content-MD5" : "")
                    + " request-line\", signature=\"" + signature + "\"";

            headers.put("Authorization", authorizationHeader);
        } catch (NoSuchAlgorithmException e) {
            throw new APIException("Could not find the MD5 algorithm. Check machine configuration");
        } catch (UnsupportedEncodingException e) {
            throw new APIException("Could not find UTF-8 encoding. Check machine configuration");
        } catch (InvalidKeyException e) {
            throw new APIException("Invalid HMAC authorization key. Check machine configuration");
        }
    }

    private static String getMd5HashFor(String body) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] messageBytes = body.getBytes("UTF-8");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] md5Bytes = md5.digest(messageBytes);

        return toHexString(md5Bytes);
    }

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();

        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        String hexString = formatter.toString();
        formatter.close();

        return hexString;
    }

    private static String createHmacEncodedSignatureFrom(String dateHeader, String contentSignature, String body,
            String url, Map<String, String> headers)
            throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        String signingString = "date: " + dateHeader + "\n" + contentSignature
                + ((body != null && !body.isEmpty()) ? "POST " : "GET ") + url.replace(Configuration.baseUri, "")
                + " HTTP/1.1";

        return getHmacEncodingFor(signingString);
    }

    /**
     * Checks if HMAC authentication is configured.
     * 
     * @return True if it is, False otherwise.
     */
    private static boolean hmacIsConfigured() {
        return Configuration.hmacAuthUserName != null && !Configuration.hmacAuthUserName.isEmpty()
                && Configuration.hmacAuthPassword != null && !Configuration.hmacAuthPassword.isEmpty();
    }

    private static String getHmacEncodingFor(String signature)
            throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac hasher = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        hasher.init(new SecretKeySpec(Configuration.hmacAuthPassword.getBytes(), HMAC_SHA1_ALGORITHM));

        byte[] hash = hasher.doFinal(signature.getBytes());

        String base64Encoded = Base64.getEncoder().encodeToString(hash);

        return base64Encoded;
    }
}
