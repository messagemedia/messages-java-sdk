package com.messagemedia.messages.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import com.messagemedia.messages.*;
import com.messagemedia.messages.models.*;
import com.messagemedia.messages.exceptions.*;
import com.messagemedia.messages.http.client.HttpClient;
import com.messagemedia.messages.http.client.HttpContext;
import com.messagemedia.messages.http.request.HttpRequest;
import com.messagemedia.messages.http.response.HttpResponse;
import com.messagemedia.messages.http.response.HttpStringResponse;
import com.messagemedia.messages.http.client.APICallBack;
import com.messagemedia.messages.controllers.syncwrapper.APICallBackCatcher;

// TODO: Auto-generated Javadoc
/**
 * The Class MessagesController.
 */
public class MessagesController extends BaseController {
    
    /** The Constant syncObject. */
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    
    /** The instance. */
    private static MessagesController instance = null;

    /**
     * Singleton pattern implementation .
     *
     * @return The singleton instance of the MessagesController class
     */
    public static MessagesController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new MessagesController();
                }
            }
        }
        return instance;
    }

    
    /**
     * Cancel scheduled message.
     *
     * @param messageId the message id
     * @param body the body
     * @return the dynamic response
     * @throws Throwable the throwable
     */
    public DynamicResponse cancelScheduledMessage(
                final String messageId,
                final CancelScheduledMessageRequest body
    ) throws Throwable {

        HttpRequest _request = _buildCancelScheduledMessageRequest(messageId, body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCancelScheduledMessageResponse(_context);
    }

    
    /**
     * Cancel scheduled message async.
     *
     * @param messageId the message id
     * @param body the body
     * @param callBack the call back
     */
    public void cancelScheduledMessageAsync(
                final String messageId,
                final CancelScheduledMessageRequest body,
                final APICallBack<DynamicResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCancelScheduledMessageRequest(messageId, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            DynamicResponse returnValue = _handleCancelScheduledMessageResponse(_context);
                            callBack.onSuccess(_context, returnValue);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

   
    /**
     * Builds the cancel scheduled message request.
     *
     * @param messageId the message id
     * @param body the body
     * @return the http request
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws APIException the API exception
     */
    private HttpRequest _buildCancelScheduledMessageRequest(
                final String messageId,
                final CancelScheduledMessageRequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messages/{messageId}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("messageId", messageId);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("accept", "application/json");
        _headers.put("content-type", "application/json");


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().putBody(_queryUrl, _headers, APIHelper.serialize(body));

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }
        
      //apply basic or hmac-based auth
        AuthManager.apply(_queryBuilder.toString(), _request.getHeaders(), APIHelper.serialize(body));

        return _request;
    }

    
    /**
     * Handle cancel scheduled message response.
     *
     * @param _context the context
     * @return the dynamic response
     * @throws APIException the API exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private DynamicResponse _handleCancelScheduledMessageResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        DynamicResponse _result = new DynamicResponse(_response);

        return _result;
    }

    
    /**
     * Send messages.
     *
     * @param body the body
     * @param optHeaders the opt headers
     * @return the send messages response
     * @throws Throwable the throwable
     */
    public SendMessagesResponse sendMessages(
                final SendMessagesRequest body, Map<String, String> optHeaders
    ) throws Throwable {

        HttpRequest _request = _buildSendMessagesRequest(body, optHeaders);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleSendMessagesResponse(_context);
    }

    
    /**
     * Send messages async.
     *
     * @param body the body
     * @param optHeaders the opt headers
     * @param callBack the call back
     */
    public void sendMessagesAsync(
                final SendMessagesRequest body,
                Map<String, String> optHeaders,
                final APICallBack<SendMessagesResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildSendMessagesRequest(body, optHeaders);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            SendMessagesResponse returnValue = _handleSendMessagesResponse(_context);
                            callBack.onSuccess(_context, returnValue);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    
    /**
     * Builds the send messages request.
     *
     * @param body the body
     * @param optHeaders the opt headers
     * @return the http request
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws APIException the API exception
     */
    private HttpRequest _buildSendMessagesRequest(
                final SendMessagesRequest body, Map<String, String> optHeaders) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messages");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("accept", "application/json");
        _headers.put("content-type", "application/json");
        if (optHeaders != null) {
        	_headers.putAll(optHeaders);
        }

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(body));

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        //apply basic or hmac-based auth
        AuthManager.apply(_queryBuilder.toString(), _request.getHeaders(), APIHelper.serialize(body));
        
        return _request;
    }

    /**
     * Processes the response for sendMessages.
     *
     * @param _context the context
     * @throws APIException the API exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private SendMessagesResponse _handleSendMessagesResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new SendMessages400ResponseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        SendMessagesResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<SendMessagesResponse>(){});

        return _result;
    }

    
    /**
     * Gets the message status.
     *
     * @param messageId the message id
     * @return the message status
     * @throws Throwable the throwable
     */
    public GetMessageStatusResponse getMessageStatus(
                final String messageId
    ) throws Throwable {

        HttpRequest _request = _buildGetMessageStatusRequest(messageId);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetMessageStatusResponse(_context);
    }

    
 
    /**
     * Gets the message status async.
     *
     * @param messageId the message id
     * @param callBack the call back
     */
    public void getMessageStatusAsync(
                final String messageId,
                final APICallBack<GetMessageStatusResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetMessageStatusRequest(messageId);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            GetMessageStatusResponse returnValue = _handleGetMessageStatusResponse(_context);
                            callBack.onSuccess(_context, returnValue);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    
    /**
     * Builds the get message status request.
     *
     * @param messageId the message id
     * @return the http request
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws APIException the API exception
     */
    private HttpRequest _buildGetMessageStatusRequest(
                final String messageId) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messages/{messageId}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("messageId", messageId);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("accept", "application/json");


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

      //apply basic or hmac-based auth
        AuthManager.apply(_queryBuilder.toString(), _request.getHeaders());
        
        return _request;
    }

   
    /**
     * Handle get message status response.
     *
     * @param _context the context
     * @return the gets the message status response
     * @throws APIException the API exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private GetMessageStatusResponse _handleGetMessageStatusResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 404) {
            throw new APIException("Resource not found", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        GetMessageStatusResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<GetMessageStatusResponse>(){});

        return _result;
    }

}
