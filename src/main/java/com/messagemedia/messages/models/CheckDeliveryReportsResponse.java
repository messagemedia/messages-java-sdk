package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckDeliveryReportsResponse.
 */
public class CheckDeliveryReportsResponse 
        implements java.io.Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -96012171860688264L;
    
    /** The delivery reports. */
    private List<DeliveryReport> deliveryReports;
    
    /**
     *  GETTER
     * The oldest 100 unconfirmed delivery reports.
     *
     * @return the delivery reports
     */
    @JsonGetter("delivery_reports")
    public List<DeliveryReport> getDeliveryReports ( ) { 
        return this.deliveryReports;
    }
    
    /**
     *  SETTER
     * The oldest 100 unconfirmed delivery reports.
     *
     * @param value the new delivery reports
     */
    @JsonSetter("delivery_reports")
    public void setDeliveryReports (List<DeliveryReport> value) { 
        this.deliveryReports = value;
    }
 
}
