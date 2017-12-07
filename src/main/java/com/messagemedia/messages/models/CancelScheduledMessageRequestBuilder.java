/*
 * MessageMediaMessages
 *
 */
package com.messagemedia.messages.models;

public class CancelScheduledMessageRequestBuilder {
    //the instance to build
    private CancelScheduledMessageRequest cancelScheduledMessageRequest;

    /**
     * Default constructor to initialize the instance
     */
    public CancelScheduledMessageRequestBuilder() {
        cancelScheduledMessageRequest = new CancelScheduledMessageRequest();
    }

    public CancelScheduledMessageRequestBuilder status(String status) {
        cancelScheduledMessageRequest.setStatus(status);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public CancelScheduledMessageRequest build() {
        return cancelScheduledMessageRequest;
    }
}