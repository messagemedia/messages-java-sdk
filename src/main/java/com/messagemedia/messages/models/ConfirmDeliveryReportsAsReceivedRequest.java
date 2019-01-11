/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ConfirmDeliveryReportsAsReceivedRequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = 26298810435532367L;
    private List<String> deliveryReportIds;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("delivery_report_ids")
    public List<String> getDeliveryReportIds ( ) { 
        return this.deliveryReportIds;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("delivery_report_ids")
    public void setDeliveryReportIds (List<String> value) { 
        this.deliveryReportIds = value;
    }
 
}
