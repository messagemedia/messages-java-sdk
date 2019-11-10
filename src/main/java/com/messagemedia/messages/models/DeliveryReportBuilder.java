package com.messagemedia.messages.models;

import java.util.*;
import org.joda.time.DateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class DeliveryReportBuilder.
 */
public class DeliveryReportBuilder {
    
    /** The delivery report. */
    //the instance to build
    private DeliveryReport deliveryReport;

    /**
     * Default constructor to initialize the instance.
     */
    public DeliveryReportBuilder() {
        deliveryReport = new DeliveryReport();
    }

    /**
     * The URL specified as the callback URL in the original submit message request.
     *
     * @param callbackUrl the callback url
     * @return the delivery report builder
     */
    public DeliveryReportBuilder callbackUrl(String callbackUrl) {
        deliveryReport.setCallbackUrl(callbackUrl);
        return this;
    }

    /**
     * The date and time at which this delivery report was generated in UTC.
     *
     * @param dateReceived the date received
     * @return the delivery report builder
     */
    public DeliveryReportBuilder dateReceived(DateTime dateReceived) {
        deliveryReport.setDateReceived(dateReceived);
        return this;
    }

    /**
     * Deprecated, no longer in use.
     *
     * @param delay the delay
     * @return the delivery report builder
     */
    public DeliveryReportBuilder delay(Integer delay) {
        deliveryReport.setDelay(delay);
        return this;
    }

    /**
     * Unique ID for this delivery report.
     *
     * @param deliveryReportId the delivery report id
     * @return the delivery report builder
     */
    public DeliveryReportBuilder deliveryReportId(UUID deliveryReportId) {
        deliveryReport.setDeliveryReportId(deliveryReportId);
        return this;
    }

    /**
     * Unique ID of the original message.
     *
     * @param messageId the message id
     * @return the delivery report builder
     */
    public DeliveryReportBuilder messageId(UUID messageId) {
        deliveryReport.setMessageId(messageId);
        return this;
    }

    /**
     * Any metadata that was included in the original submit message request.
     *
     * @param metadata the metadata
     * @return the delivery report builder
     */
    public DeliveryReportBuilder metadata(Object metadata) {
        deliveryReport.setMetadata(metadata);
        return this;
    }

    /**
     * Text of the original message.
     *
     * @param originalText the original text
     * @return the delivery report builder
     */
    public DeliveryReportBuilder originalText(String originalText) {
        deliveryReport.setOriginalText(originalText);
        return this;
    }

    /**
     * Address from which this delivery report was received.
     *
     * @param sourceNumber the source number
     * @return the delivery report builder
     */
    public DeliveryReportBuilder sourceNumber(String sourceNumber) {
        deliveryReport.setSourceNumber(sourceNumber);
        return this;
    }

    /**
     * The status of the message as per the delivery report.
     *
     * @param status the status
     * @return the delivery report builder
     */
    public DeliveryReportBuilder status(Status2Enum status) {
        deliveryReport.setStatus(status);
        return this;
    }

    /**
     * The date and time when the message status changed in UTC. For a delivered DR this may indicate the time at which the message was received on the handset.
     *
     * @param submittedDate the submitted date
     * @return the delivery report builder
     */
    public DeliveryReportBuilder submittedDate(DateTime submittedDate) {
        deliveryReport.setSubmittedDate(submittedDate);
        return this;
    }

    /**
     * Vendor account id.
     *
     * @param vendorAccountId the vendor account id
     * @return the delivery report builder
     */
    public DeliveryReportBuilder vendorAccountId(VendorAccountId vendorAccountId) {
        deliveryReport.setVendorAccountId(vendorAccountId);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the delivery report
     */
    public DeliveryReport build() {
        return deliveryReport;
    }
}