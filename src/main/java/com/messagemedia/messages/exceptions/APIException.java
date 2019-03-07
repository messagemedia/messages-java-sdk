package com.messagemedia.messages.exceptions;

import java.io.IOException;
import java.io.InputStream;
import com.messagemedia.messages.APIHelper;
import com.messagemedia.messages.http.client.HttpContext;
import com.messagemedia.messages.http.response.HttpStringResponse;

public class APIException extends Exception {
    //UID for serialization
    private static final long serialVersionUID = 6424174253911720338L;

    //private fields
    private int responseCode;

    //private fields
    private HttpContext httpContext;

    public int getResponseCode() {
        return (httpContext != null) ? httpContext.getResponse().getStatusCode() : -1;
    }


    public HttpContext getHttpContext() {
        return httpContext;
    }


    public APIException(String reason) {
        super(reason);
    }


    public APIException(String reason, HttpContext context) {
        super(reason);
        this.httpContext = context;

        //if a derived exception class is used, then perform deserialization of response body
        if (getClass().equals(APIException.class)
            || (context == null) || (context.getResponse() == null)
            || (context.getResponse().getRawBody() == null))
            return;

        try {            
            String response_body = ((HttpStringResponse)context.getResponse()).getBody();
            APIHelper.populate(response_body, this);
        } catch (IOException ioException) { }
    }
}