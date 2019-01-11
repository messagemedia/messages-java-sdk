/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
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

    /**
     * The oldest 100 unconfirmed delivery reports
     */
    public CheckDeliveryReportsResponseBuilder deliveryReports(List<DeliveryReport> deliveryReports) {
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