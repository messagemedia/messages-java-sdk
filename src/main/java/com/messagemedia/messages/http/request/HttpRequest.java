package com.messagemedia.messages.http.request;

import com.messagemedia.messages.http.request.HttpMethod;

import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class HttpRequest.
 */
public class HttpRequest {
    
    /** Private store for properties. */
    private HttpMethod httpMethod;
    
    /** The headers. */
    private Map<String, String> headers;
    
    /** The query url. */
    private String queryUrl;
    
    /** The parameters. */
    private List<SimpleEntry<String, Object>> parameters;
    
    /** The username. */
    private String username;
    
    /** The password. */
    private String password;

  
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }


    public Map<String, String> getHeaders() {
        return headers;
    }


    public String getQueryUrl() {
        return queryUrl;
    }

 
    public List<SimpleEntry<String, Object>> getParameters() {
        return parameters;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public HttpRequest(HttpMethod _method, String _queryUrl,
                       Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters) {
        this.httpMethod = _method;
        this.queryUrl = _queryUrl;
        this.headers = _headers;
        this.parameters = _parameters;
    }


    public HttpRequest(HttpMethod _method, String _queryUrl,
                       Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                       String _username, String _password) {
        this(_method, _queryUrl, _headers, _parameters);
        this.username = _username;
        this.password = _password;
    }
}
