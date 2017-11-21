/*
 * MessageMediaMessages
 *
 */
package com.messagemedia.messages.models;

import java.util.*;

public class CheckDeliveryReportsResponseBuilder {
    //the instance to build
    private CheckDeliveryReportsResponse checkDeliveryReportsResponse;

    /**
     * Default constructor to initialize the instance
     */
    public CheckDeliveryReportsResponseBuilder() {
        checkDeliveryReportsResponse = new CheckDeliveryReportsResponse();
    }

    public CheckDeliveryReportsResponseBuilder deliveryReports(List<Object> deliveryReports) {
        checkDeliveryReportsResponse.setDeliveryReports(deliveryReports);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public CheckDeliveryReportsResponse build() {
        return checkDeliveryReportsResponse;
    }
}