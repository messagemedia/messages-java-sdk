package com.messagemedia.messages.models;

import java.util.*;
import org.joda.time.DateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class ReplyBuilder.
 */
public class ReplyBuilder {
    
    /** The reply. */
    //the instance to build
    private Reply reply;

    /**
     * Default constructor to initialize the instance.
     */
    public ReplyBuilder() {
        reply = new Reply();
    }

    /**
     * The URL specified as the callback URL in the original submit message request.
     *
     * @param callbackUrl the callback url
     * @return the reply builder
     */
    public ReplyBuilder callbackUrl(String callbackUrl) {
        reply.setCallbackUrl(callbackUrl);
        return this;
    }

    /**
     * Content of the reply.
     *
     * @param content the content
     * @return the reply builder
     */
    public ReplyBuilder content(String content) {
        reply.setContent(content);
        return this;
    }

    /**
     * Date time when the reply was received.
     *
     * @param dateReceived the date received
     * @return the reply builder
     */
    public ReplyBuilder dateReceived(DateTime dateReceived) {
        reply.setDateReceived(dateReceived);
        return this;
    }

    /**
     * Address from which this reply was sent to.
     *
     * @param destinationNumber the destination number
     * @return the reply builder
     */
    public ReplyBuilder destinationNumber(String destinationNumber) {
        reply.setDestinationNumber(destinationNumber);
        return this;
    }

    /**
     * Unique ID of the original message.
     *
     * @param messageId the message id
     * @return the reply builder
     */
    public ReplyBuilder messageId(UUID messageId) {
        reply.setMessageId(messageId);
        return this;
    }

    /**
     * Any metadata that was included in the original submit message request.
     *
     * @param metadata the metadata
     * @return the reply builder
     */
    public ReplyBuilder metadata(Object metadata) {
        reply.setMetadata(metadata);
        return this;
    }

    /**
     * Unique ID of this reply.
     *
     * @param replyId the reply id
     * @return the reply builder
     */
    public ReplyBuilder replyId(UUID replyId) {
        reply.setReplyId(replyId);
        return this;
    }

    /**
     * Address from which this reply was received from.
     *
     * @param sourceNumber the source number
     * @return the reply builder
     */
    public ReplyBuilder sourceNumber(String sourceNumber) {
        reply.setSourceNumber(sourceNumber);
        return this;
    }

    /**
     * Vendor account id.
     *
     * @param vendorAccountId the vendor account id
     * @return the reply builder
     */
    public ReplyBuilder vendorAccountId(VendorAccountId vendorAccountId) {
        reply.setVendorAccountId(vendorAccountId);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the reply
     */
    public Reply build() {
        return reply;
    }
}