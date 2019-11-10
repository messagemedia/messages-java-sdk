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

// TODO: Auto-generated Javadoc
/**
 * The Class DeliveryReport.
 */
public class DeliveryReport 
        implements java.io.Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5330264263728569316L;
    
    /** The callback url. */
    private String callbackUrl;
    
    /** The date received. */
    private DateTime dateReceived;
    
    /** The delay. */
    private Integer delay;
    
    /** The delivery report id. */
    private UUID deliveryReportId;
    
    /** The message id. */
    private UUID messageId;
    
    /** The metadata. */
    private Object metadata;
    
    /** The original text. */
    private String originalText;
    
    /** The source number. */
    private String sourceNumber;
    
    /** The status. */
    private Status2Enum status;
    
    /** The submitted date. */
    private DateTime submittedDate;
    
    /** The vendor account id. */
    private VendorAccountId vendorAccountId;
    
    /**
     *  GETTER
     * The URL specified as the callback URL in the original submit message request.
     *
     * @return the callback url
     */
    @JsonGetter("callback_url")
    public String getCallbackUrl ( ) { 
        return this.callbackUrl;
    }
    
    /**
     *  SETTER
     * The URL specified as the callback URL in the original submit message request.
     *
     * @param value the new callback url
     */
    @JsonSetter("callback_url")
    public void setCallbackUrl (String value) { 
        this.callbackUrl = value;
    }
 
    /**
     *  GETTER
     * The date and time at which this delivery report was generated in UTC.
     *
     * @return the date received
     */
    @JsonGetter("date_received")
    @JsonSerialize(using=DateTimeHelper.Rfc8601DateTimeSerializer.class)
    public DateTime getDateReceived ( ) { 
        return this.dateReceived;
    }
    
    /**
     *  SETTER
     * The date and time at which this delivery report was generated in UTC.
     *
     * @param value the new date received
     */
    @JsonSetter("date_received")
    @JsonDeserialize(using=DateTimeHelper.Rfc8601DateTimeDeserializer.class)
    public void setDateReceived (DateTime value) { 
        this.dateReceived = value;
    }
 
    /**
     *  GETTER
     * Deprecated, no longer in use.
     *
     * @return the delay
     */
    @JsonGetter("delay")
    public Integer getDelay ( ) { 
        return this.delay;
    }
    
    /**
     *  SETTER
     * Deprecated, no longer in use.
     *
     * @param value the new delay
     */
    @JsonSetter("delay")
    public void setDelay (Integer value) { 
        this.delay = value;
    }
 
    /**
     *  GETTER
     * Unique ID for this delivery report.
     *
     * @return the delivery report id
     */
    @JsonGetter("delivery_report_id")
    public UUID getDeliveryReportId ( ) { 
        return this.deliveryReportId;
    }
    
    /**
     *  SETTER
     * Unique ID for this delivery report.
     *
     * @param value the new delivery report id
     */
    @JsonSetter("delivery_report_id")
    public void setDeliveryReportId (UUID value) { 
        this.deliveryReportId = value;
    }
 
    /**
     *  GETTER
     * Unique ID of the original message.
     *
     * @return the message id
     */
    @JsonGetter("message_id")
    public UUID getMessageId ( ) { 
        return this.messageId;
    }
    
    /**
     *  SETTER
     * Unique ID of the original message.
     *
     * @param value the new message id
     */
    @JsonSetter("message_id")
    public void setMessageId (UUID value) { 
        this.messageId = value;
    }
 
    /**
     *  GETTER
     * Any metadata that was included in the original submit message request.
     *
     * @return the metadata
     */
    @JsonGetter("metadata")
    public Object getMetadata ( ) { 
        return this.metadata;
    }
    
    /**
     *  SETTER
     * Any metadata that was included in the original submit message request.
     *
     * @param value the new metadata
     */
    @JsonSetter("metadata")
    public void setMetadata (Object value) { 
        this.metadata = value;
    }
 
    /**
     *  GETTER
     * Text of the original message.
     *
     * @return the original text
     */
    @JsonGetter("original_text")
    public String getOriginalText ( ) { 
        return this.originalText;
    }
    
    /**
     *  SETTER
     * Text of the original message.
     *
     * @param value the new original text
     */
    @JsonSetter("original_text")
    public void setOriginalText (String value) { 
        this.originalText = value;
    }
 
    /**
     *  GETTER
     * Address from which this delivery report was received.
     *
     * @return the source number
     */
    @JsonGetter("source_number")
    public String getSourceNumber ( ) { 
        return this.sourceNumber;
    }
    
    /**
     *  SETTER
     * Address from which this delivery report was received.
     *
     * @param value the new source number
     */
    @JsonSetter("source_number")
    public void setSourceNumber (String value) { 
        this.sourceNumber = value;
    }
 
    /**
     *  GETTER
     * The status of the message as per the delivery report.
     *
     * @return the status
     */
    @JsonGetter("status")
    public Status2Enum getStatus ( ) { 
        return this.status;
    }
    
    /**
     *  SETTER
     * The status of the message as per the delivery report.
     *
     * @param value the new status
     */
    @JsonSetter("status")
    public void setStatus (Status2Enum value) { 
        this.status = value;
    }
 
    /**
     *  GETTER
     * The date and time when the message status changed in UTC. For a delivered DR this may indicate the time at which the message was received on the handset.
     *
     * @return the submitted date
     */
    @JsonGetter("submitted_date")
    @JsonSerialize(using=DateTimeHelper.Rfc8601DateTimeSerializer.class)
    public DateTime getSubmittedDate ( ) { 
        return this.submittedDate;
    }
    
    /**
     *  SETTER
     * The date and time when the message status changed in UTC. For a delivered DR this may indicate the time at which the message was received on the handset.
     *
     * @param value the new submitted date
     */
    @JsonSetter("submitted_date")
    @JsonDeserialize(using=DateTimeHelper.Rfc8601DateTimeDeserializer.class)
    public void setSubmittedDate (DateTime value) { 
        this.submittedDate = value;
    }
 
    /**
     *  GETTER
     * TODO: Write general description for this method.
     *
     * @return the vendor account id
     */
    @JsonGetter("vendor_account_id")
    public VendorAccountId getVendorAccountId ( ) { 
        return this.vendorAccountId;
    }
    
    /**
     *  SETTER
     * TODO: Write general description for this method.
     *
     * @param value the new vendor account id
     */
    @JsonSetter("vendor_account_id")
    public void setVendorAccountId (VendorAccountId value) { 
        this.vendorAccountId = value;
    }
 
}
