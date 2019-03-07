package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.messagemedia.messages.DateTimeHelper;
import org.joda.time.DateTime;

public class DeliveryReport 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5330264263728569316L;
    private String callbackUrl;
    private DateTime dateReceived;
    private Integer delay;
    private UUID deliveryReportId;
    private UUID messageId;
    private Object metadata;
    private String originalText;
    private String sourceNumber;
    private Status2Enum status;
    private DateTime submittedDate;
    private VendorAccountId vendorAccountId;

    @JsonGetter("callback_url")
    public String getCallbackUrl ( ) { 
        return this.callbackUrl;
    }
    

    @JsonSetter("callback_url")
    public void setCallbackUrl (String value) { 
        this.callbackUrl = value;
    }
 

    @JsonGetter("date_received")
    @JsonSerialize(using=DateTimeHelper.Rfc8601DateTimeSerializer.class)
    public DateTime getDateReceived ( ) { 
        return this.dateReceived;
    }
    
 
    @JsonSetter("date_received")
    @JsonDeserialize(using=DateTimeHelper.Rfc8601DateTimeDeserializer.class)
    public void setDateReceived (DateTime value) { 
        this.dateReceived = value;
    }
 
  
    @JsonGetter("delay")
    public Integer getDelay ( ) { 
        return this.delay;
    }
    

    @JsonSetter("delay")
    public void setDelay (Integer value) { 
        this.delay = value;
    }
 
    @JsonGetter("delivery_report_id")
    public UUID getDeliveryReportId ( ) { 
        return this.deliveryReportId;
    }
    

    @JsonSetter("delivery_report_id")
    public void setDeliveryReportId (UUID value) { 
        this.deliveryReportId = value;
    }
 
  
    @JsonGetter("message_id")
    public UUID getMessageId ( ) { 
        return this.messageId;
    }

    @JsonSetter("message_id")
    public void setMessageId (UUID value) { 
        this.messageId = value;
    }
 
  
    @JsonGetter("metadata")
    public Object getMetadata ( ) { 
        return this.metadata;
    }
    

    @JsonSetter("metadata")
    public void setMetadata (Object value) { 
        this.metadata = value;
    }
 
   
    @JsonGetter("original_text")
    public String getOriginalText ( ) { 
        return this.originalText;
    }
    
 
    @JsonSetter("original_text")
    public void setOriginalText (String value) { 
        this.originalText = value;
    }
 

    @JsonGetter("source_number")
    public String getSourceNumber ( ) { 
        return this.sourceNumber;
    }
    
  
    @JsonSetter("source_number")
    public void setSourceNumber (String value) { 
        this.sourceNumber = value;
    }
 
  
    @JsonGetter("status")
    public Status2Enum getStatus ( ) { 
        return this.status;
    }
    
  
    @JsonSetter("status")
    public void setStatus (Status2Enum value) { 
        this.status = value;
    }
 
 
    @JsonGetter("submitted_date")
    @JsonSerialize(using=DateTimeHelper.Rfc8601DateTimeSerializer.class)
    public DateTime getSubmittedDate ( ) { 
        return this.submittedDate;
    }
    

    @JsonSetter("submitted_date")
    @JsonDeserialize(using=DateTimeHelper.Rfc8601DateTimeDeserializer.class)
    public void setSubmittedDate (DateTime value) { 
        this.submittedDate = value;
    }
 

    @JsonGetter("vendor_account_id")
    public VendorAccountId getVendorAccountId ( ) { 
        return this.vendorAccountId;
    }
    
  
    @JsonSetter("vendor_account_id")
    public void setVendorAccountId (VendorAccountId value) { 
        this.vendorAccountId = value;
    }
 
}
