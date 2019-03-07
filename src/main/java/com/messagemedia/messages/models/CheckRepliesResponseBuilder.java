package com.messagemedia.messages.models;

import java.util.*;

public class CheckRepliesResponseBuilder {
    //the instance to build
    private CheckRepliesResponse checkRepliesResponse;

  
    public CheckRepliesResponseBuilder() {
        checkRepliesResponse = new CheckRepliesResponse();
    }

 
    public CheckRepliesResponseBuilder replies(List<Reply> replies) {
        checkRepliesResponse.setReplies(replies);
        return this;
    }

    public CheckRepliesResponse build() {
        return checkRepliesResponse;
    }
}