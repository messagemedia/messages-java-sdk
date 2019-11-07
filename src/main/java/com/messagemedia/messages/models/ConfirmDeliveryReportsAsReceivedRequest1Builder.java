package com.messagemedia.messages.models;

import java.util.*;

public class ConfirmDeliveryReportsAsReceivedRequest1Builder {
    //the instance to build
    private ConfirmDeliveryReportsAsReceivedRequest1 confirmDeliveryReportsAsReceivedRequest1;

    /**
     * Default constructor to initialize the instance
     */
    public ConfirmDeliveryReportsAsReceivedRequest1Builder() {
        confirmDeliveryReportsAsReceivedRequest1 = new ConfirmDeliveryReportsAsReceivedRequest1();
    }

    public ConfirmDeliveryReportsAsReceivedRequest1Builder deliveryReportIds(List<UUID> deliveryReportIds) {
        confirmDeliveryReportsAsReceivedRequest1.setDeliveryReportIds(deliveryReportIds);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ConfirmDeliveryReportsAsReceivedRequest1 build() {
        return confirmDeliveryReportsAsReceivedRequest1;
    }
}