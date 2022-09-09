/*
 * MessagesLib
 *
 * This file was automatically generated by APIMATIC v3.0 ( https://www.apimatic.io ).
 */

package com.messagemedia.api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.messagemedia.api.ApiHelper;
import com.messagemedia.api.AuthManager;
import com.messagemedia.api.Configuration;
import com.messagemedia.api.exceptions.ApiException;
import com.messagemedia.api.http.Headers;
import com.messagemedia.api.http.client.HttpCallback;
import com.messagemedia.api.http.client.HttpClient;
import com.messagemedia.api.http.client.HttpContext;
import com.messagemedia.api.http.request.HttpRequest;
import com.messagemedia.api.http.response.HttpResponse;
import com.messagemedia.api.http.response.HttpStringResponse;
import com.messagemedia.api.models.CheckRepliesResponse;
import com.messagemedia.api.models.ConfirmRepliesAsReceivedRequest;
import com.messagemedia.api.models.DynamicResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class RepliesController extends BaseController {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public RepliesController(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     * @param httpCallback    Callback to be called before and after the HTTP call.
     */
    public RepliesController(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Check for any replies that have been received. Replies are messages that have been sent from
     * a handset in response to a message sent by an application or messages that have been sent
     * from a handset to a inbound number associated with an account, known as a dedicated inbound
     * number (contact &lt;support@messagemedia.com&gt; for more information on dedicated inbound
     * numbers). Each request to the check replies endpoint will return any replies received that
     * have not yet been confirmed using the confirm replies endpoint. A response from the check
     * replies endpoint will have the following structure: ```json { "replies": [ { "metadata": {
     * "key1": "value1", "key2": "value2" }, "message_id": "877c19ef-fa2e-4cec-827a-e1df9b5509f7",
     * "reply_id": "a175e797-2b54-468b-9850-41a3eab32f74", "date_received":
     * "2016-12-07T08:43:00.850Z", "callback_url": "https://my.callback.url.com",
     * "destination_number": "+61491570156", "source_number": "+61491570157", "vendor_account_id": {
     * "vendor_id": "MessageMedia", "account_id": "MyAccount" }, "content": "My first reply!" }, {
     * "metadata": { "key1": "value1", "key2": "value2" }, "message_id":
     * "8f2f5927-2e16-4f1c-bd43-47dbe2a77ae4", "reply_id": "3d8d53d8-01d3-45dd-8cfa-4dfc81600f7f",
     * "date_received": "2016-12-07T08:43:00.850Z", "callback_url": "https://my.callback.url.com",
     * "destination_number": "+61491570157", "source_number": "+61491570158", "vendor_account_id": {
     * "vendor_id": "MessageMedia", "account_id": "MyAccount" }, "content": "My second reply!" } ] }
     * ``` Each reply will contain details about the reply message, as well as details of the
     * message the reply was sent in response to, including any metadata specified. Every reply will
     * have a reply ID to be used with the confirm replies endpoint. *Note: The source number and
     * destination number properties in a reply are the inverse of those specified in the message
     * the reply is in response to. The source number of the reply message is the same as the
     * destination number of the original message, and the destination number of the reply message
     * is the same as the source number of the original message. If a source number wasn't specified
     * in the original message, then the destination number property will not be present in the
     * reply message.* Subsequent requests to the check replies endpoint will return the same reply
     * messages and a maximum of 100 replies will be returned in each request. Applications should
     * use the confirm replies endpoint in the following pattern so that replies that have been
     * processed are no longer returned in subsequent check replies requests. 1. Call check replies
     * endpoint 2. Process each reply message 3. Confirm all processed reply messages using the
     * confirm replies endpoint *Note: It is recommended to use the Webhooks feature to receive
     * reply messages rather than polling the check replies endpoint.*.
     * @return    Returns the CheckRepliesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CheckRepliesResponse getCheckReplies() throws ApiException, IOException {
        HttpRequest request = buildGetCheckRepliesRequest();
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleGetCheckRepliesResponse(context);
    }

    /**
     * Check for any replies that have been received. Replies are messages that have been sent from
     * a handset in response to a message sent by an application or messages that have been sent
     * from a handset to a inbound number associated with an account, known as a dedicated inbound
     * number (contact &lt;support@messagemedia.com&gt; for more information on dedicated inbound
     * numbers). Each request to the check replies endpoint will return any replies received that
     * have not yet been confirmed using the confirm replies endpoint. A response from the check
     * replies endpoint will have the following structure: ```json { "replies": [ { "metadata": {
     * "key1": "value1", "key2": "value2" }, "message_id": "877c19ef-fa2e-4cec-827a-e1df9b5509f7",
     * "reply_id": "a175e797-2b54-468b-9850-41a3eab32f74", "date_received":
     * "2016-12-07T08:43:00.850Z", "callback_url": "https://my.callback.url.com",
     * "destination_number": "+61491570156", "source_number": "+61491570157", "vendor_account_id": {
     * "vendor_id": "MessageMedia", "account_id": "MyAccount" }, "content": "My first reply!" }, {
     * "metadata": { "key1": "value1", "key2": "value2" }, "message_id":
     * "8f2f5927-2e16-4f1c-bd43-47dbe2a77ae4", "reply_id": "3d8d53d8-01d3-45dd-8cfa-4dfc81600f7f",
     * "date_received": "2016-12-07T08:43:00.850Z", "callback_url": "https://my.callback.url.com",
     * "destination_number": "+61491570157", "source_number": "+61491570158", "vendor_account_id": {
     * "vendor_id": "MessageMedia", "account_id": "MyAccount" }, "content": "My second reply!" } ] }
     * ``` Each reply will contain details about the reply message, as well as details of the
     * message the reply was sent in response to, including any metadata specified. Every reply will
     * have a reply ID to be used with the confirm replies endpoint. *Note: The source number and
     * destination number properties in a reply are the inverse of those specified in the message
     * the reply is in response to. The source number of the reply message is the same as the
     * destination number of the original message, and the destination number of the reply message
     * is the same as the source number of the original message. If a source number wasn't specified
     * in the original message, then the destination number property will not be present in the
     * reply message.* Subsequent requests to the check replies endpoint will return the same reply
     * messages and a maximum of 100 replies will be returned in each request. Applications should
     * use the confirm replies endpoint in the following pattern so that replies that have been
     * processed are no longer returned in subsequent check replies requests. 1. Call check replies
     * endpoint 2. Process each reply message 3. Confirm all processed reply messages using the
     * confirm replies endpoint *Note: It is recommended to use the Webhooks feature to receive
     * reply messages rather than polling the check replies endpoint.*.
     * @return    Returns the CheckRepliesResponse response from the API call
     */
    public CompletableFuture<CheckRepliesResponse> getCheckRepliesAsync() {
        return makeHttpCallAsync(() -> buildGetCheckRepliesRequest(),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleGetCheckRepliesResponse(context));
    }

    /**
     * Builds the HttpRequest object for getCheckReplies.
     */
    private HttpRequest buildGetCheckRepliesRequest() {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/replies");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseController.userAgent);
        headers.add("accept", "application/json");

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for getCheckReplies.
     * @return An object of type CheckRepliesResponse
     */
    private CheckRepliesResponse handleGetCheckRepliesResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        CheckRepliesResponse result = ApiHelper.deserialize(responseBody,
                CheckRepliesResponse.class);

        return result;
    }

    /**
     * Mark a reply message as confirmed so it is no longer returned in check replies requests. The
     * confirm replies endpoint is intended to be used in conjunction with the check replies
     * endpoint to allow for robust processing of reply messages. Once one or more reply messages
     * have been processed they can then be confirmed using the confirm replies endpoint so they are
     * no longer returned in subsequent check replies requests. The confirm replies endpoint takes a
     * list of reply IDs as follows: ```json { "reply_ids": [
     * "011dcead-6988-4ad6-a1c7-6b6c68ea628d", "3487b3fa-6586-4979-a233-2d1b095c7718",
     * "ba28e94b-c83d-4759-98e7-ff9c7edb87a1" ] } ``` Up to 100 replies can be confirmed in a single
     * confirm replies request.
     * @param  contentType  Required parameter: Example:
     * @param  body  Required parameter: Example:
     * @return    Returns the DynamicResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DynamicResponse createConfirmRepliesAsReceived(
            final String contentType,
            final ConfirmRepliesAsReceivedRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateConfirmRepliesAsReceivedRequest(contentType, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateConfirmRepliesAsReceivedResponse(context);
    }

    /**
     * Mark a reply message as confirmed so it is no longer returned in check replies requests. The
     * confirm replies endpoint is intended to be used in conjunction with the check replies
     * endpoint to allow for robust processing of reply messages. Once one or more reply messages
     * have been processed they can then be confirmed using the confirm replies endpoint so they are
     * no longer returned in subsequent check replies requests. The confirm replies endpoint takes a
     * list of reply IDs as follows: ```json { "reply_ids": [
     * "011dcead-6988-4ad6-a1c7-6b6c68ea628d", "3487b3fa-6586-4979-a233-2d1b095c7718",
     * "ba28e94b-c83d-4759-98e7-ff9c7edb87a1" ] } ``` Up to 100 replies can be confirmed in a single
     * confirm replies request.
     * @param  contentType  Required parameter: Example:
     * @param  body  Required parameter: Example:
     * @return    Returns the DynamicResponse response from the API call
     */
    public CompletableFuture<DynamicResponse> createConfirmRepliesAsReceivedAsync(
            final String contentType,
            final ConfirmRepliesAsReceivedRequest body) {
        return makeHttpCallAsync(() -> buildCreateConfirmRepliesAsReceivedRequest(contentType,
                body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateConfirmRepliesAsReceivedResponse(context));
    }

    /**
     * Builds the HttpRequest object for createConfirmRepliesAsReceived.
     */
    private HttpRequest buildCreateConfirmRepliesAsReceivedRequest(
            final String contentType,
            final ConfirmRepliesAsReceivedRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/replies/confirmed");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", contentType);
        headers.add("user-agent", BaseController.userAgent);
        headers.add("accept", "application/json");

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createConfirmRepliesAsReceived.
     * @return An object of type DynamicResponse
     */
    private DynamicResponse handleCreateConfirmRepliesAsReceivedResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //Error handling using HTTP status codes
        int responseCode = response.getStatusCode();

        if (responseCode == 400) {
            throw new ApiException("", context);
        }
        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        DynamicResponse result = new DynamicResponse(response);

        return result;
    }

}