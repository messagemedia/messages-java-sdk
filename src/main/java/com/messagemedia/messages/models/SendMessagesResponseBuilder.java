package com.messagemedia.messages.models;

import java.util.*;

public class SendMessagesResponseBuilder {
    //the instance to build
    private SendMessagesResponse sendMessagesResponse;

    /**
     * Default constructor to initialize the instance
     */
    public SendMessagesResponseBuilder() {
        sendMessagesResponse = new SendMessagesResponse();
    }

    public SendMessagesResponseBuilder messages(List<Message> messages) {
        sendMessagesResponse.setMessages(messages);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SendMessagesResponse build() {
        return sendMessagesResponse;
    }
}