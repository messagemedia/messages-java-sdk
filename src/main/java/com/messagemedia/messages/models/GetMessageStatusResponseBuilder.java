package com.messagemedia.messages.models;

import java.util.*;
import org.joda.time.DateTime;

public class GetMessageStatusResponseBuilder {
    //the instance to build
    private GetMessageStatusResponse getMessageStatusResponse;

 
    public GetMessageStatusResponseBuilder() {
        getMessageStatusResponse = new GetMessageStatusResponse();
    }


    public GetMessageStatusResponseBuilder callbackUrl(String callbackUrl) {
        getMessageStatusResponse.setCallbackUrl(callbackUrl);
        return this;
    }


    public GetMessageStatusResponseBuilder content(String content) {
        getMessageStatusResponse.setContent(content);
        return this;
    }

 
    public GetMessageStatusResponseBuilder destinationNumber(String destinationNumber) {
        getMessageStatusResponse.setDestinationNumber(destinationNumber);
        return this;
    }


    public GetMessageStatusResponseBuilder deliveryReport(Boolean deliveryReport) {
        getMessageStatusResponse.setDeliveryReport(deliveryReport);
        return this;
    }

 
    public GetMessageStatusResponseBuilder format(Format1Enum format) {
        getMessageStatusResponse.setFormat(format);
        return this;
    }


    public GetMessageStatusResponseBuilder messageExpiryTimestamp(DateTime messageExpiryTimestamp) {
        getMessageStatusResponse.setMessageExpiryTimestamp(messageExpiryTimestamp);
        return this;
    }


    public GetMessageStatusResponseBuilder metadata(Object metadata) {
        getMessageStatusResponse.setMetadata(metadata);
        return this;
    }

 
    public GetMessageStatusResponseBuilder scheduled(DateTime scheduled) {
        getMessageStatusResponse.setScheduled(scheduled);
        return this;
    }

    public GetMessageStatusResponseBuilder sourceNumber(String sourceNumber) {
        getMessageStatusResponse.setSourceNumber(sourceNumber);
        return this;
    }


    public GetMessageStatusResponseBuilder sourceNumberType(SourceNumberTypeEnum sourceNumberType) {
        getMessageStatusResponse.setSourceNumberType(sourceNumberType);
        return this;
    }

 
    public GetMessageStatusResponseBuilder messageId(UUID messageId) {
        getMessageStatusResponse.setMessageId(messageId);
        return this;
    }

    public GetMessageStatusResponseBuilder status(StatusEnum status) {
        getMessageStatusResponse.setStatus(status);
        return this;
    }

    public GetMessageStatusResponse build() {
        return getMessageStatusResponse;
    }
}