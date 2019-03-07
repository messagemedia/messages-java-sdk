package com.messagemedia.messages.models;

import java.util.*;
import org.joda.time.DateTime;

public class DeliveryReportBuilder {
    //the instance to build
    private DeliveryReport deliveryReport;

    /**
     * Default constructor to initialize the instance
     */
    public DeliveryReportBuilder() {
        deliveryReport = new DeliveryReport();
    }

    /**
     * The URL specified as the callback URL in the original submit message request
     */
    public DeliveryReportBuilder callbackUrl(String callbackUrl) {
        deliveryReport.setCallbackUrl(callbackUrl);
        return this;
    }

    /**
     * The date and time at which this delivery report was generated in UTC.
     */
    public DeliveryReportBuilder dateReceived(DateTime dateReceived) {
        deliveryReport.setDateReceived(dateReceived);
        return this;
    }

    /**
     * Deprecated, no longer in use
     */
    public DeliveryReportBuilder delay(Integer delay) {
        deliveryReport.setDelay(delay);
        return this;
    }

    /**
     * Unique ID for this delivery report
     */
    public DeliveryReportBuilder deliveryReportId(UUID deliveryReportId) {
        deliveryReport.setDeliveryReportId(deliveryReportId);
        return this;
    }

    /**
     * Unique ID of the original message
     */
    public DeliveryReportBuilder messageId(UUID messageId) {
        deliveryReport.setMessageId(messageId);
        return this;
    }

    /**
     * Any metadata that was included in the original submit message request
     */
    public DeliveryReportBuilder metadata(Object metadata) {
        deliveryReport.setMetadata(metadata);
        return this;
    }

    /**
     * Text of the original message.
     */
    public DeliveryReportBuilder originalText(String originalText) {
        deliveryReport.setOriginalText(originalText);
        return this;
    }

    /**
     * Address from which this delivery report was received
     */
    public DeliveryReportBuilder sourceNumber(String sourceNumber) {
        deliveryReport.setSourceNumber(sourceNumber);
        return this;
    }

    /**
     * The status of the message as per the delivery report
     */
    public DeliveryReportBuilder status(Status2Enum status) {
        deliveryReport.setStatus(status);
        return this;
    }

    /**
     * The date and time when the message status changed in UTC. For a delivered DR this may indicate the time at which the message was received on the handset.
     */
    public DeliveryReportBuilder submittedDate(DateTime submittedDate) {
        deliveryReport.setSubmittedDate(submittedDate);
        return this;
    }

    public DeliveryReportBuilder vendorAccountId(VendorAccountId vendorAccountId) {
        deliveryReport.setVendorAccountId(vendorAccountId);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public DeliveryReport build() {
        return deliveryReport;
    }
}