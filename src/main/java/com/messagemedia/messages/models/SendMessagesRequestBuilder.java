package com.messagemedia.messages.models;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SendMessagesRequestBuilder.
 */
public class SendMessagesRequestBuilder {
    
    /** The send messages request. */
    //the instance to build
    private SendMessagesRequest sendMessagesRequest;

    /**
     * Default constructor to initialize the instance.
     */
    public SendMessagesRequestBuilder() {
        sendMessagesRequest = new SendMessagesRequest();
    }

    /**
     * Messages.
     *
     * @param messages the messages
     * @return the send messages request builder
     */
    public SendMessagesRequestBuilder messages(List<Message> messages) {
        sendMessagesRequest.setMessages(messages);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the send messages request
     */
    public SendMessagesRequest build() {
        return sendMessagesRequest;
    }
}