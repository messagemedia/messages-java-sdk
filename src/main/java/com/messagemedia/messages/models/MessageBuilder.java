package com.messagemedia.messages.models;

import java.util.*;
import org.joda.time.DateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageBuilder.
 */
public class MessageBuilder {
    
    /** The message. */
    //the instance to build
    private Message message;

    /**
     * Default constructor to initialize the instance.
     */
    public MessageBuilder() {
        message = new Message();
    }

    /**
     * URL replies and delivery reports to this message will be pushed to.
     *
     * @param callbackUrl the callback url
     * @return the message builder
     */
    public MessageBuilder callbackUrl(String callbackUrl) {
        message.setCallbackUrl(callbackUrl);
        return this;
    }

    /**
     * Content of the message.
     *
     * @param content the content
     * @return the message builder
     */
    public MessageBuilder content(String content) {
        message.setContent(content);
        return this;
    }

    /**
     * Destination number of the message.
     *
     * @param destinationNumber the destination number
     * @return the message builder
     */
    public MessageBuilder destinationNumber(String destinationNumber) {
        message.setDestinationNumber(destinationNumber);
        return this;
    }

    /**
     * Request a delivery report for this message.
     *
     * @param deliveryReport the delivery report
     * @return the message builder
     */
    public MessageBuilder deliveryReport(Boolean deliveryReport) {
        message.setDeliveryReport(deliveryReport);
        return this;
    }

    /**
     * Format of message, SMS or TTS (Text To Speech).
     *
     * @param format the format
     * @return the message builder
     */
    public MessageBuilder format(FormatEnum format) {
        message.setFormat(format);
        return this;
    }

    /**
     * Date time after which the message expires and will not be sent.
     *
     * @param messageExpiryTimestamp the message expiry timestamp
     * @return the message builder
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
     * ```.
     *
     * @param metadata the metadata
     * @return the message builder
     */
    public MessageBuilder metadata(Object metadata) {
        message.setMetadata(metadata);
        return this;
    }

    /**
     * Scheduled delivery date time of the message.
     *
     * @param scheduled the scheduled
     * @return the message builder
     */
    public MessageBuilder scheduled(DateTime scheduled) {
        message.setScheduled(scheduled);
        return this;
    }

    /**
     * Source number.
     *
     * @param sourceNumber the source number
     * @return the message builder
     */
    public MessageBuilder sourceNumber(String sourceNumber) {
        message.setSourceNumber(sourceNumber);
        return this;
    }

    /**
     * Type of source address specified, this can be INTERNATIONAL, ALPHANUMERIC or SHORTCODE.
     *
     * @param sourceNumberType the source number type
     * @return the message builder
     */
    public MessageBuilder sourceNumberType(SourceNumberTypeEnum sourceNumberType) {
        message.setSourceNumberType(sourceNumberType);
        return this;
    }

    /**
     * Unique ID of this message.
     *
     * @param messageId the message id
     * @return the message builder
     */
    public MessageBuilder messageId(UUID messageId) {
        message.setMessageId(messageId);
        return this;
    }

    /**
     * The status of the message.
     *
     * @param status the status
     * @return the message builder
     */
    public MessageBuilder status(StatusEnum status) {
        message.setStatus(status);
        return this;
    }

    /**
     * The media is used to specify the url of the media file that you are trying to send. Supported file formats include png, jpeg and gif. format parameter must be set to MMS for this to work.
     *
     * @param media the media
     * @return the message builder
     */
    public MessageBuilder media(List<String> media) {
        message.setMedia(media);
        return this;
    }

    /**
     * The subject field is used to denote subject of the MMS message and has a maximum size of 64 characters long.
     *
     * @param subject the subject
     * @return the message builder
     */
    public MessageBuilder subject(String subject) {
        message.setSubject(subject);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the message
     */
    public Message build() {
        return message;
    }
}