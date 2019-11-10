package com.messagemedia.messages.http.client;

import com.messagemedia.messages.exceptions.APIException;
import com.messagemedia.messages.http.request.HttpBodyRequest;
import com.messagemedia.messages.http.request.HttpRequest;
import com.messagemedia.messages.http.response.HttpResponse;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface HttpClient.
 */
public interface HttpClient {

     /**
      * Sets a timeout for HTTP requests.
      *
      * @param timeout the new timeout
      */
    public void setTimeout(long timeout);

    /**
     * Execute a given HttpRequest to get string response back.
     *
     * @param request the request
     * @param callBack the call back
     */
    public void executeAsStringAsync(final HttpRequest request, final APICallBack<HttpResponse> callBack);

    /**
     * Execute a given HttpRequest to get binary response back.
     *
     * @param request the request
     * @param callBack the call back
     */
    public void executeAsBinaryAsync(final HttpRequest request, final APICallBack<HttpResponse> callBack);

    /**
     * Execute a given HttpRequest to get binary response back.
     *
     * @param request the request
     * @return the http response
     * @throws APIException the API exception
     */
    public HttpResponse executeAsBinary(final HttpRequest request) throws APIException;

    /**
     * Execute a given HttpRequest to get string response back.
     *
     * @param request the request
     * @return the http response
     * @throws APIException the API exception
     */
    public HttpResponse executeAsString(final HttpRequest request) throws APIException;

    /**
     * Create a simple HTTP GET request with basic authentication.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _parameters the parameters
     * @param _username the username
     * @param _password the password
     * @return the http request
     */
    public HttpRequest get(String _queryUrl,
                    Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                    String _username, String _password);

    /**
     * Create a simple HTTP GET request.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _parameters the parameters
     * @return the http request
     */
    public HttpRequest get(String _queryUrl,
                    Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);

    /**
     * Create a simple HTTP HEAD request with basic authentication.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _parameters the parameters
     * @param _username the username
     * @param _password the password
     * @return the http request
     */
    public HttpRequest head(String _queryUrl,
            Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
            String _username, String _password);

    /**
     * Create a simple HTTP HEAD request.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _parameters the parameters
     * @return the http request
     */
    public HttpRequest head(String _queryUrl,
            Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);

    /**
     * Create an HTTP POST request with parameters.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _parameters the parameters
     * @return the http request
     */
    public HttpRequest post(String _queryUrl,
                     Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);


    /**
     * Create an HTTP POST request with parameters and with basic authentication.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _parameters the parameters
     * @param _username the username
     * @param _password the password
     * @return the http request
     */
    public HttpRequest post(String _queryUrl,
                     Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                     String _username, String _password);

    /**
     * Create an HTTP POST request with body.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _body the body
     * @return the http body request
     */
    public HttpBodyRequest postBody(String _queryUrl,
                             Map<String, String> _headers, String _body);

    /**
     * Create an HTTP POST request with body and with basic authentication.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _body the body
     * @param _username the username
     * @param _password the password
     * @return the http body request
     */
    public HttpBodyRequest postBody(String _queryUrl,
                             Map<String, String> _headers, String _body,
                             String _username, String _password);

    /**
     * Create an HTTP PUT request with parameters.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _parameters the parameters
     * @return the http request
     */
    public HttpRequest put(String _queryUrl,
                    Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);

    /**
     * Create an HTTP PUT request with parameters and with basic authentication.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _parameters the parameters
     * @param _username the username
     * @param _password the password
     * @return the http request
     */
    HttpRequest put(String _queryUrl,
                    Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                    String _username, String _password);

    /**
     * Create an HTTP PUT request with body.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _body the body
     * @return the http body request
     */
    HttpBodyRequest putBody(String _queryUrl,
                            Map<String, String> _headers, String _body);

    /**
     * Create an HTTP PUT request with body and with basic authentication.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _body the body
     * @param _username the username
     * @param _password the password
     * @return the http body request
     */
    public HttpBodyRequest putBody(String _queryUrl,
                            Map<String, String> _headers, String _body,
                            String _username, String _password);

    /**
     * Create an HTTP PATCH request with parameters.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _parameters the parameters
     * @return the http request
     */
    public HttpRequest patch(String _queryUrl,
                      Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);

    
    /**
     * Patch.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _parameters the parameters
     * @param _username the username
     * @param _password the password
     * @return the http request
     */
    HttpRequest patch(String _queryUrl,
                      Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                      String _username, String _password);

    /**
     * Create an HTTP PATCH request with body.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _body the body
     * @return the http body request
     */
    public HttpBodyRequest patchBody(String _queryUrl,
                              Map<String, String> _headers, String _body);

    /**
     * Create an HTTP PATCH request with body and with basic authentication.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _body the body
     * @param _username the username
     * @param _password the password
     * @return the http body request
     */
    public HttpBodyRequest patchBody(String _queryUrl,
                              Map<String, String> _headers, String _body,
                              String _username, String _password);

    /**
     * Create an HTTP DELETE request with parameters.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _parameters the parameters
     * @return the http request
     */
    HttpRequest delete(String _queryUrl,
                       Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters);

    /**
     * Create an HTTP DELETE request with parameters and with basic authentication.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _parameters the parameters
     * @param _username the username
     * @param _password the password
     * @return the http request
     */
    public HttpRequest delete(String _queryUrl,
                       Map<String, String> _headers, List<SimpleEntry<String, Object>> _parameters,
                       String _username, String _password);

    /**
     * Create an HTTP DELETE request with body.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _body the body
     * @return the http body request
     */
    public HttpBodyRequest deleteBody(String _queryUrl,
                               Map<String, String> _headers, String _body);

    /**
     * Create an HTTP DELETE request with body and with basic authentication.
     *
     * @param _queryUrl the query url
     * @param _headers the headers
     * @param _body the body
     * @param _username the username
     * @param _password the password
     * @return the http body request
     */
    public HttpBodyRequest deleteBody(String _queryUrl,
                               Map<String, String> _headers, String _body,
                               String _username, String _password);
}