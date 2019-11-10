package com.messagemedia.messages.models;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CancelScheduledMessageRequestBuilder.
 */
public class CancelScheduledMessageRequestBuilder {
    
    /** The cancel scheduled message request. */
    //the instance to build
    private CancelScheduledMessageRequest cancelScheduledMessageRequest;

    /**
     * Default constructor to initialize the instance.
     */
    public CancelScheduledMessageRequestBuilder() {
        cancelScheduledMessageRequest = new CancelScheduledMessageRequest();
    }

    /**
     * Status.
     *
     * @param status the status
     * @return the cancel scheduled message request builder
     */
    public CancelScheduledMessageRequestBuilder status(String status) {
        cancelScheduledMessageRequest.setStatus(status);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the cancel scheduled message request
     */
    public CancelScheduledMessageRequest build() {
        return cancelScheduledMessageRequest;
    }
}