package com.messagemedia.messages.models;

import java.util.*;

public class CancelScheduledMessageRequestBuilder {
    //the instance to build
    private CancelScheduledMessageRequest cancelScheduledMessageRequest;

 
    public CancelScheduledMessageRequestBuilder() {
        cancelScheduledMessageRequest = new CancelScheduledMessageRequest();
    }

    public CancelScheduledMessageRequestBuilder status(String status) {
        cancelScheduledMessageRequest.setStatus(status);
        return this;
    }

    public CancelScheduledMessageRequest build() {
        return cancelScheduledMessageRequest;
    }
}