package com.messagemedia.messages.models;

import java.util.*;

public class ConfirmRepliesAsReceivedRequest1Builder {
    //the instance to build
    private ConfirmRepliesAsReceivedRequest1 confirmRepliesAsReceivedRequest1;


    public ConfirmRepliesAsReceivedRequest1Builder() {
        confirmRepliesAsReceivedRequest1 = new ConfirmRepliesAsReceivedRequest1();
    }

    public ConfirmRepliesAsReceivedRequest1Builder replyIds(List<UUID> replyIds) {
        confirmRepliesAsReceivedRequest1.setReplyIds(replyIds);
        return this;
    }
  
    public ConfirmRepliesAsReceivedRequest1 build() {
        return confirmRepliesAsReceivedRequest1;
    }
}