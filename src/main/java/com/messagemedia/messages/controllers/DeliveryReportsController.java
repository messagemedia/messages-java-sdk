/*
 * MessageMediaMessages
 *
 */
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

public class DeliveryReportsController extends BaseController {    
    //private static variables for the singleton pattern
    private static Object syncObject = new Object();
    private static DeliveryReportsController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the DeliveryReportsController class 
     */
    public static DeliveryReportsController getInstance() {
        synchronized (syncObject) {
            if (null == instance) {
                instance = new DeliveryReportsController();
            }
        }
        return instance;
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
     * @return    Returns the CheckDeliveryReportsResponse response from the API call 
     */
    public CheckDeliveryReportsResponse getCheckDeliveryReports(
    ) throws Throwable {
        APICallBackCatcher<CheckDeliveryReportsResponse> callback = new APICallBackCatcher<CheckDeliveryReportsResponse>();
        getCheckDeliveryReportsAsync(callback);
        if(!callback.isSuccess())
            throw callback.getError();
        return callback.getResult();
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
     * @return    Returns the void response from the API call 
     */
    public void getCheckDeliveryReportsAsync(
                final APICallBack<CheckDeliveryReportsResponse> callBack
    ) {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;
        
        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/v1/delivery_reports");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5475139477176994136L;
            {
                    put( "user-agent", "messagemedia-messages-java-sdk-1.0.0" );
                    put( "accept", "application/json" );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null,
                                        Configuration.basicAuthUserName, Configuration.basicAuthPassword);

        //invoke the callback before request if its not null
        if (getHttpCallBack() != null)
        {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            CheckDeliveryReportsResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<CheckDeliveryReportsResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
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
     * @param    body    Required parameter: Example: 
     * @return    Returns the DynamicResponse response from the API call 
     */
    public DynamicResponse createConfirmDeliveryReportsAsReceived(
                final ConfirmDeliveryReportsAsReceivedRequest body
    ) throws Throwable {
        APICallBackCatcher<DynamicResponse> callback = new APICallBackCatcher<DynamicResponse>();
        createConfirmDeliveryReportsAsReceivedAsync(body, callback);
        if(!callback.isSuccess())
            throw callback.getError();
        return callback.getResult();
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
     * @param    body    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void createConfirmDeliveryReportsAsReceivedAsync(
                final ConfirmDeliveryReportsAsReceivedRequest body,
                final APICallBack<DynamicResponse> callBack
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;
        
        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/v1/delivery_reports/confirmed");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4985369953259144658L;
            {
                    put( "user-agent", "messagemedia-messages-java-sdk-1.0.0" );
                    put( "accept", "application/json" );
                    put( "content-type", "application/json" );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(body),
                                        Configuration.basicAuthUserName, Configuration.basicAuthPassword);

        //invoke the callback before request if its not null
        if (getHttpCallBack() != null)
        {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();
                            if (_responseCode == 400)
                                throw new APIException("", _context);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            DynamicResponse _result = new DynamicResponse(_response);

                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

}