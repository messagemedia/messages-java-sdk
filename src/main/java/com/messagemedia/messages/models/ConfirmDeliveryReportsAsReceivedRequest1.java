package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ConfirmDeliveryReportsAsReceivedRequest1 
        implements java.io.Serializable {
    private static final long serialVersionUID = -14261055760773058L;
    private List<UUID> deliveryReportIds;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("delivery_report_ids")
    public List<UUID> getDeliveryReportIds ( ) { 
        return this.deliveryReportIds;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("delivery_report_ids")
    public void setDeliveryReportIds (List<UUID> value) { 
        this.deliveryReportIds = value;
    }
 
}
