/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;

public class ConfirmDeliveryReportsAsReceivedRequest11Builder {
    //the instance to build
    private ConfirmDeliveryReportsAsReceivedRequest11 confirmDeliveryReportsAsReceivedRequest11;

    /**
     * Default constructor to initialize the instance
     */
    public ConfirmDeliveryReportsAsReceivedRequest11Builder() {
        confirmDeliveryReportsAsReceivedRequest11 = new ConfirmDeliveryReportsAsReceivedRequest11();
    }

    public ConfirmDeliveryReportsAsReceivedRequest11Builder deliveryReportIds(List<UUID> deliveryReportIds) {
        confirmDeliveryReportsAsReceivedRequest11.setDeliveryReportIds(deliveryReportIds);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ConfirmDeliveryReportsAsReceivedRequest11 build() {
        return confirmDeliveryReportsAsReceivedRequest11;
    }
}