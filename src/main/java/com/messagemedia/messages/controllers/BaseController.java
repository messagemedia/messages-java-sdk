package com.messagemedia.messages.controllers;


import com.messagemedia.messages.exceptions.*;
import com.messagemedia.messages.http.client.HttpClient;
import com.messagemedia.messages.http.client.HttpContext;
import com.messagemedia.messages.http.client.HttpCallBack;
import com.messagemedia.messages.http.client.OkClient;
import com.messagemedia.messages.http.response.HttpResponse;

public abstract class BaseController {
    /**
     * Private variable to keep shared reference of client instance
     */
    private static HttpClient clientInstance = null;
    private static final Object syncObject = new Object();
    protected static final String userAgent = "messagemedia-messages";

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
     * Validates the response against HTTP errors defined at the API level
     * @param   _response    The response recieved
     * @param   context     Context of the request and the recieved response 
     */
    protected void validateResponse(HttpResponse _response, HttpContext context) 
            throws APIException {
        //get response status code to validate
        int responseCode = _response.getStatusCode();
        if (responseCode == 400) {
            throw new APIException("Request was invalid", context);
        }

        if (responseCode == 404) {
            throw new APIException("Message not found", context);
        }

        if ((responseCode < 200) || (responseCode > 208)) { //[200,208] = HTTP OK
            throw new APIException("HTTP Response Not OK", context);
        }
    }
}
