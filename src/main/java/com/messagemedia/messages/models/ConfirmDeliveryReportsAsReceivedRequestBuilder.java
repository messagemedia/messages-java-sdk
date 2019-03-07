package com.messagemedia.messages.models;

import java.util.*;

public class ConfirmDeliveryReportsAsReceivedRequestBuilder {
    //the instance to build
    private ConfirmDeliveryReportsAsReceivedRequest confirmDeliveryReportsAsReceivedRequest;


    public ConfirmDeliveryReportsAsReceivedRequestBuilder() {
        confirmDeliveryReportsAsReceivedRequest = new ConfirmDeliveryReportsAsReceivedRequest();
    }

    public ConfirmDeliveryReportsAsReceivedRequestBuilder deliveryReportIds(List<String> deliveryReportIds) {
        confirmDeliveryReportsAsReceivedRequest.setDeliveryReportIds(deliveryReportIds);
        return this;
    }
 
    public ConfirmDeliveryReportsAsReceivedRequest build() {
        return confirmDeliveryReportsAsReceivedRequest;
    }
}