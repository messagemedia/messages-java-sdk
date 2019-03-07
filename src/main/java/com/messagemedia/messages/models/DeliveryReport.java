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
    /** GETTER
     * The URL specified as the callback URL in the original submit message request
     */
    @JsonGetter("callback_url")
    public String getCallbackUrl ( ) { 
        return this.callbackUrl;
    }
    
    /** SETTER
     * The URL specified as the callback URL in the original submit message request
     */
    @JsonSetter("callback_url")
    public void setCallbackUrl (String value) { 
        this.callbackUrl = value;
    }
 
    /** GETTER
     * The date and time at which this delivery report was generated in UTC.
     */
    @JsonGetter("date_received")
    @JsonSerialize(using=DateTimeHelper.Rfc8601DateTimeSerializer.class)
    public DateTime getDateReceived ( ) { 
        return this.dateReceived;
    }
    
    /** SETTER
     * The date and time at which this delivery report was generated in UTC.
     */
    @JsonSetter("date_received")
    @JsonDeserialize(using=DateTimeHelper.Rfc8601DateTimeDeserializer.class)
    public void setDateReceived (DateTime value) { 
        this.dateReceived = value;
    }
 
    /** GETTER
     * Deprecated, no longer in use
     */
    @JsonGetter("delay")
    public Integer getDelay ( ) { 
        return this.delay;
    }
    
    /** SETTER
     * Deprecated, no longer in use
     */
    @JsonSetter("delay")
    public void setDelay (Integer value) { 
        this.delay = value;
    }
 
    /** GETTER
     * Unique ID for this delivery report
     */
    @JsonGetter("delivery_report_id")
    public UUID getDeliveryReportId ( ) { 
        return this.deliveryReportId;
    }
    
    /** SETTER
     * Unique ID for this delivery report
     */
    @JsonSetter("delivery_report_id")
    public void setDeliveryReportId (UUID value) { 
        this.deliveryReportId = value;
    }
 
    /** GETTER
     * Unique ID of the original message
     */
    @JsonGetter("message_id")
    public UUID getMessageId ( ) { 
        return this.messageId;
    }
    
    /** SETTER
     * Unique ID of the original message
     */
    @JsonSetter("message_id")
    public void setMessageId (UUID value) { 
        this.messageId = value;
    }
 
    /** GETTER
     * Any metadata that was included in the original submit message request
     */
    @JsonGetter("metadata")
    public Object getMetadata ( ) { 
        return this.metadata;
    }
    
    /** SETTER
     * Any metadata that was included in the original submit message request
     */
    @JsonSetter("metadata")
    public void setMetadata (Object value) { 
        this.metadata = value;
    }
 
    /** GETTER
     * Text of the original message.
     */
    @JsonGetter("original_text")
    public String getOriginalText ( ) { 
        return this.originalText;
    }
    
    /** SETTER
     * Text of the original message.
     */
    @JsonSetter("original_text")
    public void setOriginalText (String value) { 
        this.originalText = value;
    }
 
    /** GETTER
     * Address from which this delivery report was received
     */
    @JsonGetter("source_number")
    public String getSourceNumber ( ) { 
        return this.sourceNumber;
    }
    
    /** SETTER
     * Address from which this delivery report was received
     */
    @JsonSetter("source_number")
    public void setSourceNumber (String value) { 
        this.sourceNumber = value;
    }
 
    /** GETTER
     * The status of the message as per the delivery report
     */
    @JsonGetter("status")
    public Status2Enum getStatus ( ) { 
        return this.status;
    }
    
    /** SETTER
     * The status of the message as per the delivery report
     */
    @JsonSetter("status")
    public void setStatus (Status2Enum value) { 
        this.status = value;
    }
 
    /** GETTER
     * The date and time when the message status changed in UTC. For a delivered DR this may indicate the time at which the message was received on the handset.
     */
    @JsonGetter("submitted_date")
    @JsonSerialize(using=DateTimeHelper.Rfc8601DateTimeSerializer.class)
    public DateTime getSubmittedDate ( ) { 
        return this.submittedDate;
    }
    
    /** SETTER
     * The date and time when the message status changed in UTC. For a delivered DR this may indicate the time at which the message was received on the handset.
     */
    @JsonSetter("submitted_date")
    @JsonDeserialize(using=DateTimeHelper.Rfc8601DateTimeDeserializer.class)
    public void setSubmittedDate (DateTime value) { 
        this.submittedDate = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("vendor_account_id")
    public VendorAccountId getVendorAccountId ( ) { 
        return this.vendorAccountId;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("vendor_account_id")
    public void setVendorAccountId (VendorAccountId value) { 
        this.vendorAccountId = value;
    }
 
}
