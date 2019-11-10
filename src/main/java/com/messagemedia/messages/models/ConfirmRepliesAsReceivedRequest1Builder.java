package com.messagemedia.messages.models;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfirmRepliesAsReceivedRequest1Builder.
 */
public class ConfirmRepliesAsReceivedRequest1Builder {
    
    /** The confirm replies as received request 1. */
    //the instance to build
    private ConfirmRepliesAsReceivedRequest1 confirmRepliesAsReceivedRequest1;

    /**
     * Default constructor to initialize the instance.
     */
    public ConfirmRepliesAsReceivedRequest1Builder() {
        confirmRepliesAsReceivedRequest1 = new ConfirmRepliesAsReceivedRequest1();
    }

    /**
     * Reply ids.
     *
     * @param replyIds the reply ids
     * @return the confirm replies as received request 1 builder
     */
    public ConfirmRepliesAsReceivedRequest1Builder replyIds(List<UUID> replyIds) {
        confirmRepliesAsReceivedRequest1.setReplyIds(replyIds);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the confirm replies as received request 1
     */
    public ConfirmRepliesAsReceivedRequest1 build() {
        return confirmRepliesAsReceivedRequest1;
    }
}