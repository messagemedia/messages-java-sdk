package com.messagemedia.messages.models;

import java.util.*;
import org.joda.time.DateTime;

public class GetMessageStatusResponseBuilder {
    //the instance to build
    private GetMessageStatusResponse getMessageStatusResponse;

    /**
     * Default constructor to initialize the instance
     */
    public GetMessageStatusResponseBuilder() {
        getMessageStatusResponse = new GetMessageStatusResponse();
    }

    /**
     * URL replies and delivery reports to this message will be pushed to
     */
    public GetMessageStatusResponseBuilder callbackUrl(String callbackUrl) {
        getMessageStatusResponse.setCallbackUrl(callbackUrl);
        return this;
    }

    /**
     * Content of the message
     */
    public GetMessageStatusResponseBuilder content(String content) {
        getMessageStatusResponse.setContent(content);
        return this;
    }

    /**
     * Destination number of the message
     */
    public GetMessageStatusResponseBuilder destinationNumber(String destinationNumber) {
        getMessageStatusResponse.setDestinationNumber(destinationNumber);
        return this;
    }

    /**
     * Request a delivery report for this message
     */
    public GetMessageStatusResponseBuilder deliveryReport(Boolean deliveryReport) {
        getMessageStatusResponse.setDeliveryReport(deliveryReport);
        return this;
    }

    /**
     * Format of message, SMS or TTS (Text To Speech).
     */
    public GetMessageStatusResponseBuilder format(Format1Enum format) {
        getMessageStatusResponse.setFormat(format);
        return this;
    }

    /**
     * Date time after which the message expires and will not be sent
     */
    public GetMessageStatusResponseBuilder messageExpiryTimestamp(DateTime messageExpiryTimestamp) {
        getMessageStatusResponse.setMessageExpiryTimestamp(messageExpiryTimestamp);
        return this;
    }

    /**
     * Metadata for the message specified as a set of key value pairs, each key can be up to 100 characters long and each value can be up to 256 characters long
     * ```
     * {
     *    "myKey": "myValue",
     *    "anotherKey": "anotherValue"
     * }
     * ```
     */
    public GetMessageStatusResponseBuilder metadata(Object metadata) {
        getMessageStatusResponse.setMetadata(metadata);
        return this;
    }

    /**
     * Scheduled delivery date time of the message
     */
    public GetMessageStatusResponseBuilder scheduled(DateTime scheduled) {
        getMessageStatusResponse.setScheduled(scheduled);
        return this;
    }

    public GetMessageStatusResponseBuilder sourceNumber(String sourceNumber) {
        getMessageStatusResponse.setSourceNumber(sourceNumber);
        return this;
    }

    /**
     * Type of source address specified, this can be INTERNATIONAL, ALPHANUMERIC or SHORTCODE
     */
    public GetMessageStatusResponseBuilder sourceNumberType(SourceNumberTypeEnum sourceNumberType) {
        getMessageStatusResponse.setSourceNumberType(sourceNumberType);
        return this;
    }

    /**
     * Unique ID of this message
     */
    public GetMessageStatusResponseBuilder messageId(UUID messageId) {
        getMessageStatusResponse.setMessageId(messageId);
        return this;
    }

    /**
     * The status of the message
     */
    public GetMessageStatusResponseBuilder status(StatusEnum status) {
        getMessageStatusResponse.setStatus(status);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public GetMessageStatusResponse build() {
        return getMessageStatusResponse;
    }
}