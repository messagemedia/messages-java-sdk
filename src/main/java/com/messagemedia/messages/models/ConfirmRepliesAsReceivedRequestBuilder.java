package com.messagemedia.messages.models;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfirmRepliesAsReceivedRequestBuilder.
 */
public class ConfirmRepliesAsReceivedRequestBuilder {
    
    /** The confirm replies as received request. */
    //the instance to build
    private ConfirmRepliesAsReceivedRequest confirmRepliesAsReceivedRequest;

    /**
     * Default constructor to initialize the instance.
     */
    public ConfirmRepliesAsReceivedRequestBuilder() {
        confirmRepliesAsReceivedRequest = new ConfirmRepliesAsReceivedRequest();
    }

    /**
     * Reply ids.
     *
     * @param replyIds the reply ids
     * @return the confirm replies as received request builder
     */
    public ConfirmRepliesAsReceivedRequestBuilder replyIds(List<String> replyIds) {
        confirmRepliesAsReceivedRequest.setReplyIds(replyIds);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the confirm replies as received request
     */
    public ConfirmRepliesAsReceivedRequest build() {
        return confirmRepliesAsReceivedRequest;
    }
}