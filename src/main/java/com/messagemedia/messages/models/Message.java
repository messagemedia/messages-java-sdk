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

public class Message 
        implements java.io.Serializable {
    private static final long serialVersionUID = -2950295072609135979L;
    private String callbackUrl;
    private String content;
    private String destinationNumber;
    private Boolean deliveryReport = false;
    private FormatEnum format;
    private DateTime messageExpiryTimestamp;
    private Object metadata;
    private DateTime scheduled;
    private String sourceNumber;
    private SourceNumberTypeEnum sourceNumberType;
    private UUID messageId;
    private StatusEnum status;
    private List<String> media;
    private String subject;

    @JsonGetter("callback_url")
    public String getCallbackUrl ( ) { 
        return this.callbackUrl;
    }
    

    @JsonSetter("callback_url")
    public void setCallbackUrl (String value) { 
        this.callbackUrl = value;
    }
 

    @JsonGetter("content")
    public String getContent ( ) { 
        return this.content;
    }
 
    @JsonSetter("content")
    public void setContent (String value) { 
        this.content = value;
    }
 
 
    @JsonGetter("destination_number")
    public String getDestinationNumber ( ) { 
        return this.destinationNumber;
    }
    
   
    @JsonSetter("destination_number")
    public void setDestinationNumber (String value) { 
        this.destinationNumber = value;
    }
 
  
    @JsonGetter("delivery_report")
    public Boolean getDeliveryReport ( ) { 
        return this.deliveryReport;
    }
    

    @JsonSetter("delivery_report")
    public void setDeliveryReport (Boolean value) { 
        this.deliveryReport = value;
    }
 
  
    @JsonGetter("format")
    public FormatEnum getFormat ( ) { 
        return this.format;
    }
    

    @JsonSetter("format")
    public void setFormat (FormatEnum value) { 
        this.format = value;
    }
 

    @JsonGetter("message_expiry_timestamp")
    @JsonSerialize(using=DateTimeHelper.Rfc8601DateTimeSerializer.class)
    public DateTime getMessageExpiryTimestamp ( ) { 
        return this.messageExpiryTimestamp;
    }
    
  
    @JsonSetter("message_expiry_timestamp")
    @JsonDeserialize(using=DateTimeHelper.Rfc8601DateTimeDeserializer.class)
    public void setMessageExpiryTimestamp (DateTime value) { 
        this.messageExpiryTimestamp = value;
    }
 
 
    @JsonGetter("metadata")
    public Object getMetadata ( ) { 
        return this.metadata;
    }
    

    @JsonSetter("metadata")
    public void setMetadata (Object value) { 
        this.metadata = value;
    }
 
 
    @JsonGetter("scheduled")
    @JsonSerialize(using=DateTimeHelper.Rfc8601DateTimeSerializer.class)
    public DateTime getScheduled ( ) { 
        return this.scheduled;
    }

    @JsonSetter("scheduled")
    @JsonDeserialize(using=DateTimeHelper.Rfc8601DateTimeDeserializer.class)
    public void setScheduled (DateTime value) { 
        this.scheduled = value;
    }
 

    @JsonGetter("source_number")
    public String getSourceNumber ( ) { 
        return this.sourceNumber;
    }
    
  
    @JsonSetter("source_number")
    public void setSourceNumber (String value) { 
        this.sourceNumber = value;
    }
 

    @JsonGetter("source_number_type")
    public SourceNumberTypeEnum getSourceNumberType ( ) { 
        return this.sourceNumberType;
    }
    
 
    @JsonSetter("source_number_type")
    public void setSourceNumberType (SourceNumberTypeEnum value) { 
        this.sourceNumberType = value;
    }
 
 
    @JsonGetter("message_id")
    public UUID getMessageId ( ) { 
        return this.messageId;
    }
    
  
    @JsonSetter("message_id")
    public void setMessageId (UUID value) { 
        this.messageId = value;
    }
 
  
    @JsonGetter("status")
    public StatusEnum getStatus ( ) { 
        return this.status;
    }
    

    @JsonSetter("status")
    public void setStatus (StatusEnum value) { 
        this.status = value;
    }
 
  
    @JsonGetter("media")
    public List<String> getMedia ( ) { 
        return this.media;
    }
    

    @JsonSetter("media")
    public void setMedia (List<String> value) { 
        this.media = value;
    }
 
 
    @JsonGetter("subject")
    public String getSubject ( ) { 
        return this.subject;
    }
    

    @JsonSetter("subject")
    public void setSubject (String value) { 
        this.subject = value;
    }
 
}
