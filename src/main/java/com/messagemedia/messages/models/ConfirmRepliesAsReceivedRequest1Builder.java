/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;

public class ConfirmRepliesAsReceivedRequest1Builder {
    //the instance to build
    private ConfirmRepliesAsReceivedRequest1 confirmRepliesAsReceivedRequest1;

    /**
     * Default constructor to initialize the instance
     */
    public ConfirmRepliesAsReceivedRequest1Builder() {
        confirmRepliesAsReceivedRequest1 = new ConfirmRepliesAsReceivedRequest1();
    }

    public ConfirmRepliesAsReceivedRequest1Builder replyIds(List<UUID> replyIds) {
        confirmRepliesAsReceivedRequest1.setReplyIds(replyIds);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ConfirmRepliesAsReceivedRequest1 build() {
        return confirmRepliesAsReceivedRequest1;
    }
}