/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;

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