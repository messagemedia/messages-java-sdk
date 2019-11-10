package com.messagemedia.messages.http.response;

import java.io.InputStream;
import java.util.Map;
import org.apache.http.client.methods.HttpRequestBase;
// TODO: Auto-generated Javadoc

/**
 * The Class HttpResponse.
 */
public class HttpResponse {
    
    /** Private store for properties. */
    int statusCode;
    
    /** The headers. */
    Map<String, String> headers;
    
    /** The raw body. */
    InputStream rawBody;
    
    /** The base request. */
    HttpRequestBase baseRequest;    
    

    public int getStatusCode() { return statusCode; }

   
    public Map<String, String> getHeaders() {
        return headers;
    }


    public InputStream getRawBody() {
        return rawBody;
    }


    /**
     * Instantiates a new http response.
     *
     * @param _code the code
     * @param _headers the headers
     * @param _rawBody the raw body
     */
    public HttpResponse(int _code, Map<String, String> _headers, InputStream _rawBody) {
        this.statusCode = _code;
        this.headers = _headers;
        this.rawBody = _rawBody;
    }
    

    /**
     * Instantiates a new http response.
     *
     * @param _code the code
     * @param _headers the headers
     * @param _rawBody the raw body
     * @param _baseReq the base req
     */
    public HttpResponse(int _code, Map<String, String> _headers, InputStream _rawBody, HttpRequestBase _baseReq) {
        this(_code, _headers, _rawBody);
        this.baseRequest = _baseReq;
    }
 
    /**
     * Shutdowns any pending http resources e.g., input streams and realses connection
     */
    public void shutdown(){
        if(baseRequest != null) {
            baseRequest.releaseConnection();
        }
    }
}