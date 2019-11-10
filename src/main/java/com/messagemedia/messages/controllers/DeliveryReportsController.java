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
 * The Class DeliveryReportsController.
 */
public class DeliveryReportsController extends BaseController {
    
    /** The Constant syncObject. */
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    
    /** The instance. */
    private static DeliveryReportsController instance = null;

    /**
     * Singleton pattern implementation .
     *
     * @return The singleton instance of the DeliveryReportsController class
     */
    public static DeliveryReportsController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new DeliveryReportsController();
                }
            }
        }
        return instance;
    }

    /**
     * Mark a delivery report as confirmed so it is no longer return in check delivery reports requests.
     * The confirm delivery reports endpoint is intended to be used in conjunction with the check delivery
     * reports endpoint to allow for robust processing of delivery reports. Once one or more delivery
     * reports have been processed, they can then be confirmed using the confirm delivery reports endpoint so they
     * are no longer returned in subsequent check delivery reports requests.
     * The confirm delivery reports endpoint takes a list of delivery report IDs as follows:
     * ```json
     * {
     *     "delivery_report_ids": [
     *         "011dcead-6988-4ad6-a1c7-6b6c68ea628d",
     *         "3487b3fa-6586-4979-a233-2d1b095c7718",
     *         "ba28e94b-c83d-4759-98e7-ff9c7edb87a1"
     *     ]
     * }
     * ```
     * Up to 100 delivery reports can be confirmed in a single confirm delivery reports request.
     *
     * @param body the body
     * @return    Returns the DynamicResponse response from the API call
     * @throws Throwable the throwable
     */
    public DynamicResponse confirmDeliveryReportsAsReceived(
                final ConfirmDeliveryReportsAsReceivedRequest body
    ) throws Throwable {

        HttpRequest _request = _buildConfirmDeliveryReportsAsReceivedRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleConfirmDeliveryReportsAsReceivedResponse(_context);
    }

    /**
     * Mark a delivery report as confirmed so it is no longer return in check delivery reports requests.
     * The confirm delivery reports endpoint is intended to be used in conjunction with the check delivery
     * reports endpoint to allow for robust processing of delivery reports. Once one or more delivery
     * reports have been processed, they can then be confirmed using the confirm delivery reports endpoint so they
     * are no longer returned in subsequent check delivery reports requests.
     * The confirm delivery reports endpoint takes a list of delivery report IDs as follows:
     * ```json
     * {
     *     "delivery_report_ids": [
     *         "011dcead-6988-4ad6-a1c7-6b6c68ea628d",
     *         "3487b3fa-6586-4979-a233-2d1b095c7718",
     *         "ba28e94b-c83d-4759-98e7-ff9c7edb87a1"
     *     ]
     * }
     * ```
     * Up to 100 delivery reports can be confirmed in a single confirm delivery reports request.
     *
     * @param body the body
     * @param callBack the call back
     */
    public void confirmDeliveryReportsAsReceivedAsync(
                final ConfirmDeliveryReportsAsReceivedRequest body,
                final APICallBack<DynamicResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildConfirmDeliveryReportsAsReceivedRequest(body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            DynamicResponse returnValue = _handleConfirmDeliveryReportsAsReceivedResponse(_context);
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
     * Builds the HttpRequest object for confirmDeliveryReportsAsReceived.
     *
     * @param body the body
     * @return the http request
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws APIException the API exception
     */
    private HttpRequest _buildConfirmDeliveryReportsAsReceivedRequest(
                final ConfirmDeliveryReportsAsReceivedRequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/delivery_reports/confirmed");
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
     * Processes the response for confirmDeliveryReportsAsReceived.
     *
     * @param _context the context
     * @throws APIException the API exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private DynamicResponse _handleConfirmDeliveryReportsAsReceivedResponse(HttpContext _context)
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
     * Check for any delivery reports that have been received.
     * Delivery reports are a notification of the change in status of a message as it is being processed.
     * Each request to the check delivery reports endpoint will return any delivery reports received that
     * have not yet been confirmed using the confirm delivery reports endpoint. A response from the check
     * delivery reports endpoint will have the following structure:
     * ```json
     * {
     *     "delivery_reports": [
     *         {
     *             "callback_url": "https://my.callback.url.com",
     *             "delivery_report_id": "01e1fa0a-6e27-4945-9cdb-18644b4de043",
     *             "source_number": "+61491570157",
     *             "date_received": "2017-05-20T06:30:37.642Z",
     *             "status": "enroute",
     *             "delay": 0,
     *             "submitted_date": "2017-05-20T06:30:37.639Z",
     *             "original_text": "My first message!",
     *             "message_id": "d781dcab-d9d8-4fb2-9e03-872f07ae94ba",
     *             "vendor_account_id": {
     *                 "vendor_id": "MessageMedia",
     *                 "account_id": "MyAccount"
     *             },
     *             "metadata": {
     *                 "key1": "value1",
     *                 "key2": "value2"
     *             }
     *         },
     *         {
     *             "callback_url": "https://my.callback.url.com",
     *             "delivery_report_id": "0edf9022-7ccc-43e6-acab-480e93e98c1b",
     *             "source_number": "+61491570158",
     *             "date_received": "2017-05-21T01:46:42.579Z",
     *             "status": "enroute",
     *             "delay": 0,
     *             "submitted_date": "2017-05-21T01:46:42.574Z",
     *             "original_text": "My second message!",
     *             "message_id": "fbb3b3f5-b702-4d8b-ab44-65b2ee39a281",
     *             "vendor_account_id": {
     *                 "vendor_id": "MessageMedia",
     *                 "account_id": "MyAccount"
     *             },
     *             "metadata": {
     *                 "key1": "value1",
     *                 "key2": "value2"
     *             }
     *         }
     *     ]
     * }
     * ```
     * Each delivery report will contain details about the message, including any metadata specified
     * and the new status of the message (as each delivery report indicates a change in status of a
     * message) and the timestamp at which the status changed. Every delivery report will have a 
     * unique delivery report ID for use with the confirm delivery reports endpoint.
     * *Note: The source number and destination number properties in a delivery report are the inverse of
     * those specified in the message that the delivery report relates to. The source number of the
     * delivery report is the destination number of the original message.*
     * Subsequent requests to the check delivery reports endpoint will return the same delivery reports
     * and a maximum of 100 delivery reports will be returned in each request. Applications should use the
     * confirm delivery reports endpoint in the following pattern so that delivery reports that have been
     * processed are no longer returned in subsequent check delivery reports requests.
     * 1. Call check delivery reports endpoint
     * 2. Process each delivery report
     * 3. Confirm all processed delivery reports using the confirm delivery reports endpoint
     * *Note: It is recommended to use the Webhooks feature to receive reply messages rather than
     * polling the check delivery reports endpoint.*
     *
     * @return    Returns the CheckDeliveryReportsResponse response from the API call
     * @throws Throwable the throwable
     */
    public CheckDeliveryReportsResponse checkDeliveryReports(
    ) throws Throwable {

        HttpRequest _request = _buildCheckDeliveryReportsRequest();
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCheckDeliveryReportsResponse(_context);
    }

    /**
     * Check for any delivery reports that have been received.
     * Delivery reports are a notification of the change in status of a message as it is being processed.
     * Each request to the check delivery reports endpoint will return any delivery reports received that
     * have not yet been confirmed using the confirm delivery reports endpoint. A response from the check
     * delivery reports endpoint will have the following structure:
     * ```json
     * {
     *     "delivery_reports": [
     *         {
     *             "callback_url": "https://my.callback.url.com",
     *             "delivery_report_id": "01e1fa0a-6e27-4945-9cdb-18644b4de043",
     *             "source_number": "+61491570157",
     *             "date_received": "2017-05-20T06:30:37.642Z",
     *             "status": "enroute",
     *             "delay": 0,
     *             "submitted_date": "2017-05-20T06:30:37.639Z",
     *             "original_text": "My first message!",
     *             "message_id": "d781dcab-d9d8-4fb2-9e03-872f07ae94ba",
     *             "vendor_account_id": {
     *                 "vendor_id": "MessageMedia",
     *                 "account_id": "MyAccount"
     *             },
     *             "metadata": {
     *                 "key1": "value1",
     *                 "key2": "value2"
     *             }
     *         },
     *         {
     *             "callback_url": "https://my.callback.url.com",
     *             "delivery_report_id": "0edf9022-7ccc-43e6-acab-480e93e98c1b",
     *             "source_number": "+61491570158",
     *             "date_received": "2017-05-21T01:46:42.579Z",
     *             "status": "enroute",
     *             "delay": 0,
     *             "submitted_date": "2017-05-21T01:46:42.574Z",
     *             "original_text": "My second message!",
     *             "message_id": "fbb3b3f5-b702-4d8b-ab44-65b2ee39a281",
     *             "vendor_account_id": {
     *                 "vendor_id": "MessageMedia",
     *                 "account_id": "MyAccount"
     *             },
     *             "metadata": {
     *                 "key1": "value1",
     *                 "key2": "value2"
     *             }
     *         }
     *     ]
     * }
     * ```
     * Each delivery report will contain details about the message, including any metadata specified
     * and the new status of the message (as each delivery report indicates a change in status of a
     * message) and the timestamp at which the status changed. Every delivery report will have a 
     * unique delivery report ID for use with the confirm delivery reports endpoint.
     * *Note: The source number and destination number properties in a delivery report are the inverse of
     * those specified in the message that the delivery report relates to. The source number of the
     * delivery report is the destination number of the original message.*
     * Subsequent requests to the check delivery reports endpoint will return the same delivery reports
     * and a maximum of 100 delivery reports will be returned in each request. Applications should use the
     * confirm delivery reports endpoint in the following pattern so that delivery reports that have been
     * processed are no longer returned in subsequent check delivery reports requests.
     * 1. Call check delivery reports endpoint
     * 2. Process each delivery report
     * 3. Confirm all processed delivery reports using the confirm delivery reports endpoint
     * *Note: It is recommended to use the Webhooks feature to receive reply messages rather than
     * polling the check delivery reports endpoint.*
     *
     * @param callBack the call back
     */
    public void checkDeliveryReportsAsync(
                final APICallBack<CheckDeliveryReportsResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCheckDeliveryReportsRequest();
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            CheckDeliveryReportsResponse returnValue = _handleCheckDeliveryReportsResponse(_context);
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
     * Builds the HttpRequest object for checkDeliveryReports.
     *
     * @return the http request
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws APIException the API exception
     */
    private HttpRequest _buildCheckDeliveryReportsRequest() throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/delivery_reports");
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
     * Processes the response for checkDeliveryReports.
     *
     * @param _context the context
     * @throws APIException the API exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private CheckDeliveryReportsResponse _handleCheckDeliveryReportsResponse(HttpContext _context)
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
        CheckDeliveryReportsResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<CheckDeliveryReportsResponse>(){});

        return _result;
    }

}
