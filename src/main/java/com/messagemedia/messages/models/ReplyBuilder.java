package com.messagemedia.messages.models;

import java.util.*;
import org.joda.time.DateTime;

public class ReplyBuilder {
    //the instance to build
    private Reply reply;

  
    public ReplyBuilder() {
        reply = new Reply();
    }

 
    public ReplyBuilder callbackUrl(String callbackUrl) {
        reply.setCallbackUrl(callbackUrl);
        return this;
    }

  
    public ReplyBuilder content(String content) {
        reply.setContent(content);
        return this;
    }

   
    public ReplyBuilder dateReceived(DateTime dateReceived) {
        reply.setDateReceived(dateReceived);
        return this;
    }

  
    public ReplyBuilder destinationNumber(String destinationNumber) {
        reply.setDestinationNumber(destinationNumber);
        return this;
    }

  
    public ReplyBuilder messageId(UUID messageId) {
        reply.setMessageId(messageId);
        return this;
    }

   
    public ReplyBuilder metadata(Object metadata) {
        reply.setMetadata(metadata);
        return this;
    }

    public ReplyBuilder replyId(UUID replyId) {
        reply.setReplyId(replyId);
        return this;
    }

  
    public ReplyBuilder sourceNumber(String sourceNumber) {
        reply.setSourceNumber(sourceNumber);
        return this;
    }

    public ReplyBuilder vendorAccountId(VendorAccountId vendorAccountId) {
        reply.setVendorAccountId(vendorAccountId);
        return this;
    }
  
    public Reply build() {
        return reply;
    }
}