package com.messagemedia.messages.models;

import java.util.*;
import org.joda.time.DateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class GetMessageStatusResponseBuilder.
 */
public class GetMessageStatusResponseBuilder {
    
    /** The get message status response. */
    //the instance to build
    private GetMessageStatusResponse getMessageStatusResponse;

    /**
     * Default constructor to initialize the instance.
     */
    public GetMessageStatusResponseBuilder() {
        getMessageStatusResponse = new GetMessageStatusResponse();
    }

    /**
     * URL replies and delivery reports to this message will be pushed to.
     *
     * @param callbackUrl the callback url
     * @return the gets the message status response builder
     */
    public GetMessageStatusResponseBuilder callbackUrl(String callbackUrl) {
        getMessageStatusResponse.setCallbackUrl(callbackUrl);
        return this;
    }

    /**
     * Content of the message.
     *
     * @param content the content
     * @return the gets the message status response builder
     */
    public GetMessageStatusResponseBuilder content(String content) {
        getMessageStatusResponse.setContent(content);
        return this;
    }

    /**
     * Destination number of the message.
     *
     * @param destinationNumber the destination number
     * @return the gets the message status response builder
     */
    public GetMessageStatusResponseBuilder destinationNumber(String destinationNumber) {
        getMessageStatusResponse.setDestinationNumber(destinationNumber);
        return this;
    }

    /**
     * Request a delivery report for this message.
     *
     * @param deliveryReport the delivery report
     * @return the gets the message status response builder
     */
    public GetMessageStatusResponseBuilder deliveryReport(Boolean deliveryReport) {
        getMessageStatusResponse.setDeliveryReport(deliveryReport);
        return this;
    }

    /**
     * Format of message, SMS or TTS (Text To Speech).
     *
     * @param format the format
     * @return the gets the message status response builder
     */
    public GetMessageStatusResponseBuilder format(Format1Enum format) {
        getMessageStatusResponse.setFormat(format);
        return this;
    }

    /**
     * Date time after which the message expires and will not be sent.
     *
     * @param messageExpiryTimestamp the message expiry timestamp
     * @return the gets the message status response builder
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
     * ```.
     *
     * @param metadata the metadata
     * @return the gets the message status response builder
     */
    public GetMessageStatusResponseBuilder metadata(Object metadata) {
        getMessageStatusResponse.setMetadata(metadata);
        return this;
    }

    /**
     * Scheduled delivery date time of the message.
     *
     * @param scheduled the scheduled
     * @return the gets the message status response builder
     */
    public GetMessageStatusResponseBuilder scheduled(DateTime scheduled) {
        getMessageStatusResponse.setScheduled(scheduled);
        return this;
    }

    /**
     * Source number.
     *
     * @param sourceNumber the source number
     * @return the gets the message status response builder
     */
    public GetMessageStatusResponseBuilder sourceNumber(String sourceNumber) {
        getMessageStatusResponse.setSourceNumber(sourceNumber);
        return this;
    }

    /**
     * Type of source address specified, this can be INTERNATIONAL, ALPHANUMERIC or SHORTCODE.
     *
     * @param sourceNumberType the source number type
     * @return the gets the message status response builder
     */
    public GetMessageStatusResponseBuilder sourceNumberType(SourceNumberTypeEnum sourceNumberType) {
        getMessageStatusResponse.setSourceNumberType(sourceNumberType);
        return this;
    }

    /**
     * Unique ID of this message.
     *
     * @param messageId the message id
     * @return the gets the message status response builder
     */
    public GetMessageStatusResponseBuilder messageId(UUID messageId) {
        getMessageStatusResponse.setMessageId(messageId);
        return this;
    }

    /**
     * The status of the message.
     *
     * @param status the status
     * @return the gets the message status response builder
     */
    public GetMessageStatusResponseBuilder status(StatusEnum status) {
        getMessageStatusResponse.setStatus(status);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the gets the message status response
     */
    public GetMessageStatusResponse build() {
        return getMessageStatusResponse;
    }
}