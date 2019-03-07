package com.messagemedia.messages.http.response;

import java.io.InputStream;
import java.util.Map;
import org.apache.http.client.methods.HttpRequestBase;
public class HttpResponse {
 
    int statusCode;
    Map<String, String> headers;
    InputStream rawBody;
    HttpRequestBase baseRequest;    
  
    public int getStatusCode() { return statusCode; }

 
    public Map<String, String> getHeaders() {
        return headers;
    }

  
    public InputStream getRawBody() {
        return rawBody;
    }


    public HttpResponse(int _code, Map<String, String> _headers, InputStream _rawBody) {
        this.statusCode = _code;
        this.headers = _headers;
        this.rawBody = _rawBody;
    }
    

    public HttpResponse(int _code, Map<String, String> _headers, InputStream _rawBody, HttpRequestBase _baseReq) {
        this(_code, _headers, _rawBody);
        this.baseRequest = _baseReq;
    }

    public void shutdown(){
        if(baseRequest != null) {
            baseRequest.releaseConnection();
        }
    }
}