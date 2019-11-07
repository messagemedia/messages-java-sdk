package com.messagemedia.messages.models;

import java.util.*;
import org.joda.time.DateTime;

public class ReplyBuilder {
    //the instance to build
    private Reply reply;

    /**
     * Default constructor to initialize the instance
     */
    public ReplyBuilder() {
        reply = new Reply();
    }

    /**
     * The URL specified as the callback URL in the original submit message request
     */
    public ReplyBuilder callbackUrl(String callbackUrl) {
        reply.setCallbackUrl(callbackUrl);
        return this;
    }

    /**
     * Content of the reply
     */
    public ReplyBuilder content(String content) {
        reply.setContent(content);
        return this;
    }

    /**
     * Date time when the reply was received
     */
    public ReplyBuilder dateReceived(DateTime dateReceived) {
        reply.setDateReceived(dateReceived);
        return this;
    }

    /**
     * Address from which this reply was sent to
     */
    public ReplyBuilder destinationNumber(String destinationNumber) {
        reply.setDestinationNumber(destinationNumber);
        return this;
    }

    /**
     * Unique ID of the original message
     */
    public ReplyBuilder messageId(UUID messageId) {
        reply.setMessageId(messageId);
        return this;
    }

    /**
     * Any metadata that was included in the original submit message request
     */
    public ReplyBuilder metadata(Object metadata) {
        reply.setMetadata(metadata);
        return this;
    }

    /**
     * Unique ID of this reply
     */
    public ReplyBuilder replyId(UUID replyId) {
        reply.setReplyId(replyId);
        return this;
    }

    /**
     * Address from which this reply was received from
     */
    public ReplyBuilder sourceNumber(String sourceNumber) {
        reply.setSourceNumber(sourceNumber);
        return this;
    }

    public ReplyBuilder vendorAccountId(VendorAccountId vendorAccountId) {
        reply.setVendorAccountId(vendorAccountId);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Reply build() {
        return reply;
    }
}