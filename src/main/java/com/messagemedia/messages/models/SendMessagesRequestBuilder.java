package com.messagemedia.messages.models;

import java.util.*;

public class SendMessagesRequestBuilder {
    //the instance to build
    private SendMessagesRequest sendMessagesRequest;


    public SendMessagesRequestBuilder() {
        sendMessagesRequest = new SendMessagesRequest();
    }

    public SendMessagesRequestBuilder messages(List<Message> messages) {
        sendMessagesRequest.setMessages(messages);
        return this;
    }

    public SendMessagesRequest build() {
        return sendMessagesRequest;
    }
}