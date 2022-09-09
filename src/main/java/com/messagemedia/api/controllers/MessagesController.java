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
import com.messagemedia.api.models.CancelScheduledMessageRequest;
import com.messagemedia.api.models.DynamicResponse;
import com.messagemedia.api.models.SendMessagesRequest;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class MessagesController extends BaseController {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public MessagesController(Configuration config, HttpClient httpClient,
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
    public MessagesController(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Retrieve the current status of a message using the message ID returned in the send messages
     * end point. A successful request to the get message status endpoint will return a response
     * body as follows: ```json { "format": "SMS", "content": "My first message!", "metadata": {
     * "key1": "value1", "key2": "value2" }, "message_id": "877c19ef-fa2e-4cec-827a-e1df9b5509f7",
     * "callback_url": "https://my.callback.url.com", "delivery_report": true, "destination_number":
     * "+61401760575", "scheduled": "2016-11-03T11:49:02.807Z", "source_number": "+61491570157",
     * "source_number_type": "INTERNATIONAL" "message_expiry_timestamp": "2016-11-03T11:49:02.807Z",
     * "status": "enroute" } ``` The status property of the response indicates the current status of
     * the message. See the Delivery Reports section of this documentation for more information on
     * message statues. *Note: If an invalid or non existent message ID parameter is specified in
     * the request, then a HTTP 404 Not Found response will be returned*.
     * @param  messageId  Required parameter: Example:
     * @return    Returns the DynamicResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DynamicResponse getMessageStatus(
            final String messageId) throws ApiException, IOException {
        HttpRequest request = buildGetMessageStatusRequest(messageId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleGetMessageStatusResponse(context);
    }

    /**
     * Retrieve the current status of a message using the message ID returned in the send messages
     * end point. A successful request to the get message status endpoint will return a response
     * body as follows: ```json { "format": "SMS", "content": "My first message!", "metadata": {
     * "key1": "value1", "key2": "value2" }, "message_id": "877c19ef-fa2e-4cec-827a-e1df9b5509f7",
     * "callback_url": "https://my.callback.url.com", "delivery_report": true, "destination_number":
     * "+61401760575", "scheduled": "2016-11-03T11:49:02.807Z", "source_number": "+61491570157",
     * "source_number_type": "INTERNATIONAL" "message_expiry_timestamp": "2016-11-03T11:49:02.807Z",
     * "status": "enroute" } ``` The status property of the response indicates the current status of
     * the message. See the Delivery Reports section of this documentation for more information on
     * message statues. *Note: If an invalid or non existent message ID parameter is specified in
     * the request, then a HTTP 404 Not Found response will be returned*.
     * @param  messageId  Required parameter: Example:
     * @return    Returns the DynamicResponse response from the API call
     */
    public CompletableFuture<DynamicResponse> getMessageStatusAsync(
            final String messageId) {
        return makeHttpCallAsync(() -> buildGetMessageStatusRequest(messageId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleGetMessageStatusResponse(context));
    }

    /**
     * Builds the HttpRequest object for getMessageStatus.
     */
    private HttpRequest buildGetMessageStatusRequest(
            final String messageId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/messages/{messageId}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("messageId",
                new SimpleEntry<Object, Boolean>(messageId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

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
     * Processes the response for getMessageStatus.
     * @return An object of type DynamicResponse
     */
    private DynamicResponse handleGetMessageStatusResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //Error handling using HTTP status codes
        int responseCode = response.getStatusCode();

        if (responseCode == 404) {
            throw new ApiException("", context);
        }
        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        DynamicResponse result = new DynamicResponse(response);

        return result;
    }

    /**
     * Cancel a scheduled message that has not yet been delivered. A scheduled message can be
     * cancelled by updating the status of a message from ```scheduled``` to ```cancelled```. This
     * is done by submitting a PUT request to the messages endpoint using the message ID as a
     * parameter (the same endpoint used above to retrieve the status of a message). The body of the
     * request simply needs to contain a ```status``` property with the value set to
     * ```cancelled```. ```json { "status": "cancelled" } ``` *Note: Only messages with a status of
     * scheduled can be cancelled. If an invalid or non existent message ID parameter is specified
     * in the request, then a HTTP 404 Not Found response will be returned*.
     * @param  messageId  Required parameter: Example:
     * @param  contentType  Required parameter: Example:
     * @param  body  Required parameter: Example:
     * @return    Returns the DynamicResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DynamicResponse updateCancelScheduledMessage(
            final String messageId,
            final String contentType,
            final CancelScheduledMessageRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateCancelScheduledMessageRequest(messageId, contentType,
                body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateCancelScheduledMessageResponse(context);
    }

    /**
     * Cancel a scheduled message that has not yet been delivered. A scheduled message can be
     * cancelled by updating the status of a message from ```scheduled``` to ```cancelled```. This
     * is done by submitting a PUT request to the messages endpoint using the message ID as a
     * parameter (the same endpoint used above to retrieve the status of a message). The body of the
     * request simply needs to contain a ```status``` property with the value set to
     * ```cancelled```. ```json { "status": "cancelled" } ``` *Note: Only messages with a status of
     * scheduled can be cancelled. If an invalid or non existent message ID parameter is specified
     * in the request, then a HTTP 404 Not Found response will be returned*.
     * @param  messageId  Required parameter: Example:
     * @param  contentType  Required parameter: Example:
     * @param  body  Required parameter: Example:
     * @return    Returns the DynamicResponse response from the API call
     */
    public CompletableFuture<DynamicResponse> updateCancelScheduledMessageAsync(
            final String messageId,
            final String contentType,
            final CancelScheduledMessageRequest body) {
        return makeHttpCallAsync(() -> buildUpdateCancelScheduledMessageRequest(messageId,
                contentType, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdateCancelScheduledMessageResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateCancelScheduledMessage.
     */
    private HttpRequest buildUpdateCancelScheduledMessageRequest(
            final String messageId,
            final String contentType,
            final CancelScheduledMessageRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/messages/{messageId}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("messageId",
                new SimpleEntry<Object, Boolean>(messageId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", contentType);
        headers.add("user-agent", BaseController.userAgent);
        headers.add("accept", "application/json");

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateCancelScheduledMessage.
     * @return An object of type DynamicResponse
     */
    private DynamicResponse handleUpdateCancelScheduledMessageResponse(
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
        if (responseCode == 404) {
            throw new ApiException("", context);
        }
        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        DynamicResponse result = new DynamicResponse(response);

        return result;
    }

    /**
     * Submit one or more (up to 100 per request) SMS or text to voice messages for delivery.
     * @param  body  Required parameter: Example:
     * @return    Returns the DynamicResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DynamicResponse createSendMessages(
            final SendMessagesRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateSendMessagesRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateSendMessagesResponse(context);
    }

    /**
     * Submit one or more (up to 100 per request) SMS or text to voice messages for delivery.
     * @param  body  Required parameter: Example:
     * @return    Returns the DynamicResponse response from the API call
     */
    public CompletableFuture<DynamicResponse> createSendMessagesAsync(
            final SendMessagesRequest body) {
        return makeHttpCallAsync(() -> buildCreateSendMessagesRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateSendMessagesResponse(context));
    }

    /**
     * Builds the HttpRequest object for createSendMessages.
     */
    private HttpRequest buildCreateSendMessagesRequest(
            final SendMessagesRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v1/messages");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseController.userAgent);
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");

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
     * Processes the response for createSendMessages.
     * @return An object of type DynamicResponse
     */
    private DynamicResponse handleCreateSendMessagesResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //Error handling using HTTP status codes
        int responseCode = response.getStatusCode();

        if (responseCode == 400) {
            throw new ApiException("Error", context);
        }
        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        DynamicResponse result = new DynamicResponse(response);

        return result;
    }

}