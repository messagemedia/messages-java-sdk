package com.messagemedia.messages.models;

import java.util.*;
import org.joda.time.DateTime;

public class MessageBuilder {
    //the instance to build
    private Message message;

    /**
     * Default constructor to initialize the instance
     */
    public MessageBuilder() {
        message = new Message();
    }

    /**
     * URL replies and delivery reports to this message will be pushed to
     */
    public MessageBuilder callbackUrl(String callbackUrl) {
        message.setCallbackUrl(callbackUrl);
        return this;
    }

    /**
     * Content of the message
     */
    public MessageBuilder content(String content) {
        message.setContent(content);
        return this;
    }

    /**
     * Destination number of the message
     */
    public MessageBuilder destinationNumber(String destinationNumber) {
        message.setDestinationNumber(destinationNumber);
        return this;
    }

    /**
     * Request a delivery report for this message
     */
    public MessageBuilder deliveryReport(Boolean deliveryReport) {
        message.setDeliveryReport(deliveryReport);
        return this;
    }

    /**
     * Format of message, SMS or TTS (Text To Speech).
     */
    public MessageBuilder format(FormatEnum format) {
        message.setFormat(format);
        return this;
    }

    /**
     * Date time after which the message expires and will not be sent
     */
    public MessageBuilder messageExpiryTimestamp(DateTime messageExpiryTimestamp) {
        message.setMessageExpiryTimestamp(messageExpiryTimestamp);
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
    public MessageBuilder metadata(Object metadata) {
        message.setMetadata(metadata);
        return this;
    }

    /**
     * Scheduled delivery date time of the message
     */
    public MessageBuilder scheduled(DateTime scheduled) {
        message.setScheduled(scheduled);
        return this;
    }

    public MessageBuilder sourceNumber(String sourceNumber) {
        message.setSourceNumber(sourceNumber);
        return this;
    }

    /**
     * Type of source address specified, this can be INTERNATIONAL, ALPHANUMERIC or SHORTCODE
     */
    public MessageBuilder sourceNumberType(SourceNumberTypeEnum sourceNumberType) {
        message.setSourceNumberType(sourceNumberType);
        return this;
    }

    /**
     * Unique ID of this message
     */
    public MessageBuilder messageId(UUID messageId) {
        message.setMessageId(messageId);
        return this;
    }

    /**
     * The status of the message
     */
    public MessageBuilder status(StatusEnum status) {
        message.setStatus(status);
        return this;
    }

    /**
     * The media is used to specify the url of the media file that you are trying to send. Supported file formats include png, jpeg and gif. format parameter must be set to MMS for this to work.
     */
    public MessageBuilder media(List<String> media) {
        message.setMedia(media);
        return this;
    }

    /**
     * The subject field is used to denote subject of the MMS message and has a maximum size of 64 characters long
     */
    public MessageBuilder subject(String subject) {
        message.setSubject(subject);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Message build() {
        return message;
    }
}