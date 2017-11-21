/*
 * MessageMediaMessages
 *
 */
package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CheckDeliveryReportsResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5407550748654389690L;
    private List<Object> deliveryReports;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("delivery_reports")
    public List<Object> getDeliveryReports ( ) { 
        return this.deliveryReports;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("delivery_reports")
    public void setDeliveryReports (List<Object> value) { 
        this.deliveryReports = value;
    }
 
}
 