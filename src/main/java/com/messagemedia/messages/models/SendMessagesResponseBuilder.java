package com.messagemedia.messages.models;

import java.util.*;

public class SendMessagesResponseBuilder {
    //the instance to build
    private SendMessagesResponse sendMessagesResponse;


    public SendMessagesResponseBuilder() {
        sendMessagesResponse = new SendMessagesResponse();
    }

    public SendMessagesResponseBuilder messages(List<Message> messages) {
        sendMessagesResponse.setMessages(messages);
        return this;
    }
  
    public SendMessagesResponse build() {
        return sendMessagesResponse;
    }
}