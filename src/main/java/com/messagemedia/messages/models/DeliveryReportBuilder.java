package com.messagemedia.messages.models;

import java.util.*;
import org.joda.time.DateTime;

public class DeliveryReportBuilder {
    //the instance to build
    private DeliveryReport deliveryReport;


    public DeliveryReportBuilder() {
        deliveryReport = new DeliveryReport();
    }

 
    public DeliveryReportBuilder callbackUrl(String callbackUrl) {
        deliveryReport.setCallbackUrl(callbackUrl);
        return this;
    }

  
    public DeliveryReportBuilder dateReceived(DateTime dateReceived) {
        deliveryReport.setDateReceived(dateReceived);
        return this;
    }

    public DeliveryReportBuilder delay(Integer delay) {
        deliveryReport.setDelay(delay);
        return this;
    }

 
    public DeliveryReportBuilder deliveryReportId(UUID deliveryReportId) {
        deliveryReport.setDeliveryReportId(deliveryReportId);
        return this;
    }

   
    public DeliveryReportBuilder messageId(UUID messageId) {
        deliveryReport.setMessageId(messageId);
        return this;
    }

 
    public DeliveryReportBuilder metadata(Object metadata) {
        deliveryReport.setMetadata(metadata);
        return this;
    }

 
    public DeliveryReportBuilder originalText(String originalText) {
        deliveryReport.setOriginalText(originalText);
        return this;
    }

  
    public DeliveryReportBuilder sourceNumber(String sourceNumber) {
        deliveryReport.setSourceNumber(sourceNumber);
        return this;
    }

 
    public DeliveryReportBuilder status(Status2Enum status) {
        deliveryReport.setStatus(status);
        return this;
    }

  
    public DeliveryReportBuilder submittedDate(DateTime submittedDate) {
        deliveryReport.setSubmittedDate(submittedDate);
        return this;
    }

    public DeliveryReportBuilder vendorAccountId(VendorAccountId vendorAccountId) {
        deliveryReport.setVendorAccountId(vendorAccountId);
        return this;
    }
 
    public DeliveryReport build() {
        return deliveryReport;
    }
}