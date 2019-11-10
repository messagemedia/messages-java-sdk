package com.messagemedia.messages.models;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SendMessagesResponseBuilder.
 */
public class SendMessagesResponseBuilder {
    
    /** The send messages response. */
    //the instance to build
    private SendMessagesResponse sendMessagesResponse;

    /**
     * Default constructor to initialize the instance.
     */
    public SendMessagesResponseBuilder() {
        sendMessagesResponse = new SendMessagesResponse();
    }

    /**
     * Messages.
     *
     * @param messages the messages
     * @return the send messages response builder
     */
    public SendMessagesResponseBuilder messages(List<Message> messages) {
        sendMessagesResponse.setMessages(messages);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the send messages response
     */
    public SendMessagesResponse build() {
        return sendMessagesResponse;
    }
}