/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CheckDeliveryReportsResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -96012171860688264L;
    private List<DeliveryReport> deliveryReports;
    /** GETTER
     * The oldest 100 unconfirmed delivery reports
     */
    @JsonGetter("delivery_reports")
    public List<DeliveryReport> getDeliveryReports ( ) { 
        return this.deliveryReports;
    }
    
    /** SETTER
     * The oldest 100 unconfirmed delivery reports
     */
    @JsonSetter("delivery_reports")
    public void setDeliveryReports (List<DeliveryReport> value) { 
        this.deliveryReports = value;
    }
 
}
