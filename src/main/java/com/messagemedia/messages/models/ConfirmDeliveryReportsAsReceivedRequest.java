package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ConfirmDeliveryReportsAsReceivedRequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = 26298810435532367L;
    private List<String> deliveryReportIds;

    @JsonGetter("delivery_report_ids")
    public List<String> getDeliveryReportIds ( ) { 
        return this.deliveryReportIds;
    }
    
 
    @JsonSetter("delivery_report_ids")
    public void setDeliveryReportIds (List<String> value) { 
        this.deliveryReportIds = value;
    }
 
}
