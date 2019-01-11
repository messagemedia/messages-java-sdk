/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;

public class ConfirmRepliesAsReceivedRequestBuilder {
    //the instance to build
    private ConfirmRepliesAsReceivedRequest confirmRepliesAsReceivedRequest;

    /**
     * Default constructor to initialize the instance
     */
    public ConfirmRepliesAsReceivedRequestBuilder() {
        confirmRepliesAsReceivedRequest = new ConfirmRepliesAsReceivedRequest();
    }

    public ConfirmRepliesAsReceivedRequestBuilder replyIds(List<String> replyIds) {
        confirmRepliesAsReceivedRequest.setReplyIds(replyIds);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ConfirmRepliesAsReceivedRequest build() {
        return confirmRepliesAsReceivedRequest;
    }
}