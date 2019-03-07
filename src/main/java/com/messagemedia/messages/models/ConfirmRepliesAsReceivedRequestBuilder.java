package com.messagemedia.messages.models;

import java.util.*;

public class ConfirmRepliesAsReceivedRequestBuilder {
    //the instance to build
    private ConfirmRepliesAsReceivedRequest confirmRepliesAsReceivedRequest;


    public ConfirmRepliesAsReceivedRequestBuilder() {
        confirmRepliesAsReceivedRequest = new ConfirmRepliesAsReceivedRequest();
    }

    public ConfirmRepliesAsReceivedRequestBuilder replyIds(List<String> replyIds) {
        confirmRepliesAsReceivedRequest.setReplyIds(replyIds);
        return this;
    }
  
    public ConfirmRepliesAsReceivedRequest build() {
        return confirmRepliesAsReceivedRequest;
    }
}