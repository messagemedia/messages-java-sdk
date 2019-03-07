package com.messagemedia.messages.models;

import java.util.*;

public class CheckDeliveryReportsResponseBuilder {
    //the instance to build
    private CheckDeliveryReportsResponse checkDeliveryReportsResponse;

  
    public CheckDeliveryReportsResponseBuilder() {
        checkDeliveryReportsResponse = new CheckDeliveryReportsResponse();
    }

  
    public CheckDeliveryReportsResponseBuilder deliveryReports(List<DeliveryReport> deliveryReports) {
        checkDeliveryReportsResponse.setDeliveryReports(deliveryReports);
        return this;
    }
  
    public CheckDeliveryReportsResponse build() {
        return checkDeliveryReportsResponse;
    }
}