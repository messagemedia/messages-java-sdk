/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;

public class ConfirmDeliveryReportsAsReceivedRequestBuilder {
    //the instance to build
    private ConfirmDeliveryReportsAsReceivedRequest confirmDeliveryReportsAsReceivedRequest;

    /**
     * Default constructor to initialize the instance
     */
    public ConfirmDeliveryReportsAsReceivedRequestBuilder() {
        confirmDeliveryReportsAsReceivedRequest = new ConfirmDeliveryReportsAsReceivedRequest();
    }

    public ConfirmDeliveryReportsAsReceivedRequestBuilder deliveryReportIds(List<String> deliveryReportIds) {
        confirmDeliveryReportsAsReceivedRequest.setDeliveryReportIds(deliveryReportIds);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ConfirmDeliveryReportsAsReceivedRequest build() {
        return confirmDeliveryReportsAsReceivedRequest;
    }
}