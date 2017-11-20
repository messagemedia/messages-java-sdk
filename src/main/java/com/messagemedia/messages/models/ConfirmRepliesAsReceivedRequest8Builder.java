/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;

public class ConfirmRepliesAsReceivedRequest8Builder {
    //the instance to build
    private ConfirmRepliesAsReceivedRequest8 confirmRepliesAsReceivedRequest8;

    /**
     * Default constructor to initialize the instance
     */
    public ConfirmRepliesAsReceivedRequest8Builder() {
        confirmRepliesAsReceivedRequest8 = new ConfirmRepliesAsReceivedRequest8();
    }

    public ConfirmRepliesAsReceivedRequest8Builder replyIds(List<UUID> replyIds) {
        confirmRepliesAsReceivedRequest8.setReplyIds(replyIds);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ConfirmRepliesAsReceivedRequest8 build() {
        return confirmRepliesAsReceivedRequest8;
    }
}