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
 * The Class RepliesController.
 */
public class RepliesController extends BaseController {
    
    /** The Constant syncObject. */
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    
    /** The instance. */
    private static RepliesController instance = null;

    /**
     * Singleton pattern implementation .
     *
     * @return The singleton instance of the RepliesController class
     */
    public static RepliesController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new RepliesController();
                }
            }
        }
        return instance;
    }

    
    /**
     * Check replies.
     *
     * @return the check replies response
     * @throws Throwable the throwable
     */
    public CheckRepliesResponse checkReplies(
    ) throws Throwable {

        HttpRequest _request = _buildCheckRepliesRequest();
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCheckRepliesResponse(_context);
    }

  
    /**
     * Check replies async.
     *
     * @param callBack the call back
     */
    public void checkRepliesAsync(
                final APICallBack<CheckRepliesResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCheckRepliesRequest();
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            CheckRepliesResponse returnValue = _handleCheckRepliesResponse(_context);
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
     * Builds the HttpRequest object for checkReplies.
     *
     * @return the http request
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws APIException the API exception
     */
    private HttpRequest _buildCheckRepliesRequest() throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/replies");
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
     * Processes the response for checkReplies.
     *
     * @param _context the context
     * @return An object of type void
     * @throws APIException the API exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private CheckRepliesResponse _handleCheckRepliesResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        CheckRepliesResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<CheckRepliesResponse>(){});

        return _result;
    }

    
    /**
     * Confirm replies as received.
     *
     * @param body the body
     * @return the dynamic response
     * @throws Throwable the throwable
     */
    public DynamicResponse confirmRepliesAsReceived(
                final ConfirmRepliesAsReceivedRequest body
    ) throws Throwable {

        HttpRequest _request = _buildConfirmRepliesAsReceivedRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleConfirmRepliesAsReceivedResponse(_context);
    }

    
    /**
     * Confirm replies as received async.
     *
     * @param body the body
     * @param callBack the call back
     */
    public void confirmRepliesAsReceivedAsync(
                final ConfirmRepliesAsReceivedRequest body,
                final APICallBack<DynamicResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildConfirmRepliesAsReceivedRequest(body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            DynamicResponse returnValue = _handleConfirmRepliesAsReceivedResponse(_context);
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
     * Builds the HttpRequest object for confirmRepliesAsReceived.
     *
     * @param body the body
     * @return the http request
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws APIException the API exception
     */
    private HttpRequest _buildConfirmRepliesAsReceivedRequest(
                final ConfirmRepliesAsReceivedRequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/replies/confirmed");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("accept", "application/json");
        _headers.put("content-type", "application/json");


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
     * Processes the response for confirmRepliesAsReceived.
     *
     * @param _context the context
     * @return An object of type void
     * @throws APIException the API exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private DynamicResponse _handleConfirmRepliesAsReceivedResponse(HttpContext _context)
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

}
