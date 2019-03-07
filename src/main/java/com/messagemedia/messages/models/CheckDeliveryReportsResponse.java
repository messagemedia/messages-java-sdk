package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class CheckDeliveryReportsResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -96012171860688264L;
    private List<DeliveryReport> deliveryReports;
   
    @JsonGetter("delivery_reports")
    public List<DeliveryReport> getDeliveryReports ( ) { 
        return this.deliveryReports;
    }
    
 
    @JsonSetter("delivery_reports")
    public void setDeliveryReports (List<DeliveryReport> value) { 
        this.deliveryReports = value;
    }
 
}
