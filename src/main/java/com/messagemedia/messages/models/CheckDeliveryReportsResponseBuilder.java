package com.messagemedia.messages.models;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckDeliveryReportsResponseBuilder.
 */
public class CheckDeliveryReportsResponseBuilder {
    
    /** The check delivery reports response. */
    //the instance to build
    private CheckDeliveryReportsResponse checkDeliveryReportsResponse;

    /**
     * Default constructor to initialize the instance.
     */
    public CheckDeliveryReportsResponseBuilder() {
        checkDeliveryReportsResponse = new CheckDeliveryReportsResponse();
    }

    /**
     * The oldest 100 unconfirmed delivery reports.
     *
     * @param deliveryReports the delivery reports
     * @return the check delivery reports response builder
     */
    public CheckDeliveryReportsResponseBuilder deliveryReports(List<DeliveryReport> deliveryReports) {
        checkDeliveryReportsResponse.setDeliveryReports(deliveryReports);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the check delivery reports response
     */
    public CheckDeliveryReportsResponse build() {
        return checkDeliveryReportsResponse;
    }
}