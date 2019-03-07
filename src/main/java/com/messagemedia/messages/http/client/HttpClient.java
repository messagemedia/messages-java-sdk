package com.messagemedia.messages.http.client;

import com.messagemedia.messages.exceptions.APIException;
import com.messagemedia.messages.http.request.HttpBodyRequest;
import com.messagemedia.messages.http.request.HttpRequest;
import com.messagemedia.messages.http.response.HttpResponse;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

public interface HttpClient {

 
    public void setTimeout(long timeout);


    public void executeAsStringAsync(final HttpRequest request, final APICallBack<HttpResponse> callBack);

 
    public void executeAsBinaryAsync(final HttpRequest request, final APICallBack<HttpResponse> callBack);

  
    public HttpResponse executeAsBinary(final HttpRequest request) throws APIException;

 
    public HttpResponse executeAsString(final HttpRequest request) throws APIException;

 
    public HttpRequest get(String _queryUrl,
                    Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                    String _username, String _password);

 
    public HttpRequest get(String _queryUrl,
                    Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);

 
    public HttpRequest head(String _queryUrl,
            Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
            String _username, String _password);

  
    public HttpRequest head(String _queryUrl,
            Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);

  
    public HttpRequest post(String _queryUrl,
                     Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);



    public HttpRequest post(String _queryUrl,
                     Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                     String _username, String _password);

  
    public HttpBodyRequest postBody(String _queryUrl,
                             Map<String, String> _headers, String _body);


    public HttpBodyRequest postBody(String _queryUrl,
                             Map<String, String> _headers, String _body,
                             String _username, String _password);


    public HttpRequest put(String _queryUrl,
                    Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);

 
    HttpRequest put(String _queryUrl,
                    Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                    String _username, String _password);

   
    HttpBodyRequest putBody(String _queryUrl,
                            Map<String, String> _headers, String _body);

  
    public HttpBodyRequest putBody(String _queryUrl,
                            Map<String, String> _headers, String _body,
                            String _username, String _password);

   
    public HttpRequest patch(String _queryUrl,
                      Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);


    HttpRequest patch(String _queryUrl,
                      Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                      String _username, String _password);

    public HttpBodyRequest patchBody(String _queryUrl,
                              Map<String, String> _headers, String _body);

  
    public HttpBodyRequest patchBody(String _queryUrl,
                              Map<String, String> _headers, String _body,
                              String _username, String _password);

  
    HttpRequest delete(String _queryUrl,
                       Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);

  
    public HttpRequest delete(String _queryUrl,
                       Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                       String _username, String _password);

  
    public HttpBodyRequest deleteBody(String _queryUrl,
                               Map<String, String> _headers, String _body);

   
    public HttpBodyRequest deleteBody(String _queryUrl,
                               Map<String, String> _headers, String _body,
                               String _username, String _password);
}