/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;

public class SendMessagesRequestBuilder {
    //the instance to build
    private SendMessagesRequest sendMessagesRequest;

    /**
     * Default constructor to initialize the instance
     */
    public SendMessagesRequestBuilder() {
        sendMessagesRequest = new SendMessagesRequest();
    }

    public SendMessagesRequestBuilder messages(List<Object> messages) {
        sendMessagesRequest.setMessages(messages);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SendMessagesRequest build() {
        return sendMessagesRequest;
    }
}