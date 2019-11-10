package com.messagemedia.messages.models;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfirmDeliveryReportsAsReceivedRequestBuilder.
 */
public class ConfirmDeliveryReportsAsReceivedRequestBuilder {
    
    /** The confirm delivery reports as received request. */
    //the instance to build
    private ConfirmDeliveryReportsAsReceivedRequest confirmDeliveryReportsAsReceivedRequest;

    /**
     * Default constructor to initialize the instance.
     */
    public ConfirmDeliveryReportsAsReceivedRequestBuilder() {
        confirmDeliveryReportsAsReceivedRequest = new ConfirmDeliveryReportsAsReceivedRequest();
    }

    /**
     * Delivery report ids.
     *
     * @param deliveryReportIds the delivery report ids
     * @return the confirm delivery reports as received request builder
     */
    public ConfirmDeliveryReportsAsReceivedRequestBuilder deliveryReportIds(List<String> deliveryReportIds) {
        confirmDeliveryReportsAsReceivedRequest.setDeliveryReportIds(deliveryReportIds);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the confirm delivery reports as received request
     */
    public ConfirmDeliveryReportsAsReceivedRequest build() {
        return confirmDeliveryReportsAsReceivedRequest;
    }
}