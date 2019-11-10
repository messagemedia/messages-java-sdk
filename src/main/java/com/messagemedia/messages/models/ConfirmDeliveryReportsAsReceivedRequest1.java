package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfirmDeliveryReportsAsReceivedRequest1.
 */
public class ConfirmDeliveryReportsAsReceivedRequest1 
        implements java.io.Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -14261055760773058L;
    
    /** The delivery report ids. */
    private List<UUID> deliveryReportIds;
    
    /**
     *  GETTER
     * TODO: Write general description for this method.
     *
     * @return the delivery report ids
     */
    @JsonGetter("delivery_report_ids")
    public List<UUID> getDeliveryReportIds ( ) { 
        return this.deliveryReportIds;
    }
    
    /**
     *  SETTER
     * TODO: Write general description for this method.
     *
     * @param value the new delivery report ids
     */
    @JsonSetter("delivery_report_ids")
    public void setDeliveryReportIds (List<UUID> value) { 
        this.deliveryReportIds = value;
    }
 
}
