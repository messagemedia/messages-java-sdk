package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfirmDeliveryReportsAsReceivedRequest.
 */
public class ConfirmDeliveryReportsAsReceivedRequest 
        implements java.io.Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 26298810435532367L;
    
    /** The delivery report ids. */
    private List<String> deliveryReportIds;
    
    /**
     *  GETTER
     * TODO: Write general description for this method.
     *
     * @return the delivery report ids
     */
    @JsonGetter("delivery_report_ids")
    public List<String> getDeliveryReportIds ( ) { 
        return this.deliveryReportIds;
    }
    
    /**
     *  SETTER
     * TODO: Write general description for this method.
     *
     * @param value the new delivery report ids
     */
    @JsonSetter("delivery_report_ids")
    public void setDeliveryReportIds (List<String> value) { 
        this.deliveryReportIds = value;
    }
 
}
