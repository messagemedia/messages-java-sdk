package com.messagemedia.messages.models;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfirmDeliveryReportsAsReceivedRequest1Builder.
 */
public class ConfirmDeliveryReportsAsReceivedRequest1Builder {
    
    /** The confirm delivery reports as received request 1. */
    //the instance to build
    private ConfirmDeliveryReportsAsReceivedRequest1 confirmDeliveryReportsAsReceivedRequest1;

    /**
     * Default constructor to initialize the instance.
     */
    public ConfirmDeliveryReportsAsReceivedRequest1Builder() {
        confirmDeliveryReportsAsReceivedRequest1 = new ConfirmDeliveryReportsAsReceivedRequest1();
    }

    /**
     * Delivery report ids.
     *
     * @param deliveryReportIds the delivery report ids
     * @return the confirm delivery reports as received request 1 builder
     */
    public ConfirmDeliveryReportsAsReceivedRequest1Builder deliveryReportIds(List<UUID> deliveryReportIds) {
        confirmDeliveryReportsAsReceivedRequest1.setDeliveryReportIds(deliveryReportIds);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the confirm delivery reports as received request 1
     */
    public ConfirmDeliveryReportsAsReceivedRequest1 build() {
        return confirmDeliveryReportsAsReceivedRequest1;
    }
}