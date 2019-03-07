package com.messagemedia.messages.models;

import java.util.*;
import org.joda.time.DateTime;

public class MessageBuilder {
    //the instance to build
    private Message message;

  
    public MessageBuilder() {
        message = new Message();
    }


    public MessageBuilder callbackUrl(String callbackUrl) {
        message.setCallbackUrl(callbackUrl);
        return this;
    }

 
    public MessageBuilder content(String content) {
        message.setContent(content);
        return this;
    }


    public MessageBuilder destinationNumber(String destinationNumber) {
        message.setDestinationNumber(destinationNumber);
        return this;
    }


    public MessageBuilder deliveryReport(Boolean deliveryReport) {
        message.setDeliveryReport(deliveryReport);
        return this;
    }


    public MessageBuilder format(FormatEnum format) {
        message.setFormat(format);
        return this;
    }

  
    public MessageBuilder messageExpiryTimestamp(DateTime messageExpiryTimestamp) {
        message.setMessageExpiryTimestamp(messageExpiryTimestamp);
        return this;
    }

  
    public MessageBuilder metadata(Object metadata) {
        message.setMetadata(metadata);
        return this;
    }


    public MessageBuilder scheduled(DateTime scheduled) {
        message.setScheduled(scheduled);
        return this;
    }

    public MessageBuilder sourceNumber(String sourceNumber) {
        message.setSourceNumber(sourceNumber);
        return this;
    }

  
    public MessageBuilder sourceNumberType(SourceNumberTypeEnum sourceNumberType) {
        message.setSourceNumberType(sourceNumberType);
        return this;
    }


    public MessageBuilder messageId(UUID messageId) {
        message.setMessageId(messageId);
        return this;
    }

  
    public MessageBuilder status(StatusEnum status) {
        message.setStatus(status);
        return this;
    }

 
    public MessageBuilder media(List<String> media) {
        message.setMedia(media);
        return this;
    }


    public MessageBuilder subject(String subject) {
        message.setSubject(subject);
        return this;
    }
 
    public Message build() {
        return message;
    }
}