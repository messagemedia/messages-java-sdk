package com.messagemedia.messages.http.response;

import java.io.InputStream;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class HttpStringResponse.
 */
public class HttpStringResponse extends HttpResponse {
    
    /** Private store for properties. */
    private String body;


    public String getBody() {
        return body;
    }

    
    public HttpStringResponse(int _code, Map<String, String> _headers, InputStream _rawBody, String body) {
        super(_code, _headers, _rawBody);
        this.body = body;
    }
}
