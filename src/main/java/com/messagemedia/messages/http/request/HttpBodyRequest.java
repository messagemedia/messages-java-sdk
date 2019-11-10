package com.messagemedia.messages.http.request;

import com.messagemedia.messages.http.request.HttpMethod;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class HttpBodyRequest.
 */
public class HttpBodyRequest extends HttpRequest {
    
    /** Private store for properties. */
    private String body;

    public String getBody() {
        return body;
    }


    public HttpBodyRequest(HttpMethod _method, String _queryUrl,
                           Map<String, String> _headers, String _body) {
        super(_method, _queryUrl, _headers, null);
        this.body = _body!=null ? _body : "";
    }


    public HttpBodyRequest(HttpMethod _method, String _queryUrl,
                           Map<String, String> _headers, String _body,
                           String _username, String _password) {
        super(_method, _queryUrl, _headers, null, _username, _password);
        this.body = _body!=null ? _body : "";
    }
}
