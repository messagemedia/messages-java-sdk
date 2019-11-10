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
 * The Class GetMessageStatusResponse.
 */
public class GetMessageStatusResponse 
        implements java.io.Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1381351086443564125L;
    
    /** The callback url. */
    private String callbackUrl;
    
    /** The content. */
    private String content;
    
    /** The destination number. */
    private String destinationNumber;
    
    /** The delivery report. */
    private Boolean deliveryReport = false;
    
    /** The format. */
    private Format1Enum format;
    
    /** The message expiry timestamp. */
    private DateTime messageExpiryTimestamp;
    
    /** The metadata. */
    private Object metadata;
    
    /** The scheduled. */
    private DateTime scheduled;
    
    /** The source number. */
    private String sourceNumber;
    
    /** The source number type. */
    private SourceNumberTypeEnum sourceNumberType;
    
    /** The message id. */
    private UUID messageId;
    
    /** The status. */
    private StatusEnum status;
    
    /**
     *  GETTER
     * URL replies and delivery reports to this message will be pushed to.
     *
     * @return the callback url
     */
    @JsonGetter("callback_url")
    public String getCallbackUrl ( ) { 
        return this.callbackUrl;
    }
    
    /**
     *  SETTER
     * URL replies and delivery reports to this message will be pushed to.
     *
     * @param value the new callback url
     */
    @JsonSetter("callback_url")
    public void setCallbackUrl (String value) { 
        this.callbackUrl = value;
    }
 
    /**
     *  GETTER
     * Content of the message.
     *
     * @return the content
     */
    @JsonGetter("content")
    public String getContent ( ) { 
        return this.content;
    }
    
    /**
     *  SETTER
     * Content of the message.
     *
     * @param value the new content
     */
    @JsonSetter("content")
    public void setContent (String value) { 
        this.content = value;
    }
 
    /**
     *  GETTER
     * Destination number of the message.
     *
     * @return the destination number
     */
    @JsonGetter("destination_number")
    public String getDestinationNumber ( ) { 
        return this.destinationNumber;
    }
    
    /**
     *  SETTER
     * Destination number of the message.
     *
     * @param value the new destination number
     */
    @JsonSetter("destination_number")
    public void setDestinationNumber (String value) { 
        this.destinationNumber = value;
    }
 
    /**
     *  GETTER
     * Request a delivery report for this message.
     *
     * @return the delivery report
     */
    @JsonGetter("delivery_report")
    public Boolean getDeliveryReport ( ) { 
        return this.deliveryReport;
    }
    
    /**
     *  SETTER
     * Request a delivery report for this message.
     *
     * @param value the new delivery report
     */
    @JsonSetter("delivery_report")
    public void setDeliveryReport (Boolean value) { 
        this.deliveryReport = value;
    }
 
    /**
     *  GETTER
     * Format of message, SMS or TTS (Text To Speech).
     *
     * @return the format
     */
    @JsonGetter("format")
    public Format1Enum getFormat ( ) { 
        return this.format;
    }
    
    /**
     *  SETTER
     * Format of message, SMS or TTS (Text To Speech).
     *
     * @param value the new format
     */
    @JsonSetter("format")
    public void setFormat (Format1Enum value) { 
        this.format = value;
    }
 
    /**
     *  GETTER
     * Date time after which the message expires and will not be sent.
     *
     * @return the message expiry timestamp
     */
    @JsonGetter("message_expiry_timestamp")
    @JsonSerialize(using=DateTimeHelper.Rfc8601DateTimeSerializer.class)
    public DateTime getMessageExpiryTimestamp ( ) { 
        return this.messageExpiryTimestamp;
    }
    
    /**
     *  SETTER
     * Date time after which the message expires and will not be sent.
     *
     * @param value the new message expiry timestamp
     */
    @JsonSetter("message_expiry_timestamp")
    @JsonDeserialize(using=DateTimeHelper.Rfc8601DateTimeDeserializer.class)
    public void setMessageExpiryTimestamp (DateTime value) { 
        this.messageExpiryTimestamp = value;
    }
 
    /**
     *  GETTER
     * Metadata for the message specified as a set of key value pairs, each key can be up to 100 characters long and each value can be up to 256 characters long
     * ```
     * {
     *    "myKey": "myValue",
     *    "anotherKey": "anotherValue"
     * }
     * ```.
     *
     * @return the metadata
     */
    @JsonGetter("metadata")
    public Object getMetadata ( ) { 
        return this.metadata;
    }
    
    /**
     *  SETTER
     * Metadata for the message specified as a set of key value pairs, each key can be up to 100 characters long and each value can be up to 256 characters long
     * ```
     * {
     *    "myKey": "myValue",
     *    "anotherKey": "anotherValue"
     * }
     * ```.
     *
     * @param value the new metadata
     */
    @JsonSetter("metadata")
    public void setMetadata (Object value) { 
        this.metadata = value;
    }
 
    /**
     *  GETTER
     * Scheduled delivery date time of the message.
     *
     * @return the scheduled
     */
    @JsonGetter("scheduled")
    @JsonSerialize(using=DateTimeHelper.Rfc8601DateTimeSerializer.class)
    public DateTime getScheduled ( ) { 
        return this.scheduled;
    }
    
    /**
     *  SETTER
     * Scheduled delivery date time of the message.
     *
     * @param value the new scheduled
     */
    @JsonSetter("scheduled")
    @JsonDeserialize(using=DateTimeHelper.Rfc8601DateTimeDeserializer.class)
    public void setScheduled (DateTime value) { 
        this.scheduled = value;
    }
 
    /**
     *  GETTER
     * TODO: Write general description for this method.
     *
     * @return the source number
     */
    @JsonGetter("source_number")
    public String getSourceNumber ( ) { 
        return this.sourceNumber;
    }
    
    /**
     *  SETTER
     * TODO: Write general description for this method.
     *
     * @param value the new source number
     */
    @JsonSetter("source_number")
    public void setSourceNumber (String value) { 
        this.sourceNumber = value;
    }
 
    /**
     *  GETTER
     * Type of source address specified, this can be INTERNATIONAL, ALPHANUMERIC or SHORTCODE.
     *
     * @return the source number type
     */
    @JsonGetter("source_number_type")
    public SourceNumberTypeEnum getSourceNumberType ( ) { 
        return this.sourceNumberType;
    }
    
    /**
     *  SETTER
     * Type of source address specified, this can be INTERNATIONAL, ALPHANUMERIC or SHORTCODE.
     *
     * @param value the new source number type
     */
    @JsonSetter("source_number_type")
    public void setSourceNumberType (SourceNumberTypeEnum value) { 
        this.sourceNumberType = value;
    }
 
    /**
     *  GETTER
     * Unique ID of this message.
     *
     * @return the message id
     */
    @JsonGetter("message_id")
    public UUID getMessageId ( ) { 
        return this.messageId;
    }
    
    /**
     *  SETTER
     * Unique ID of this message.
     *
     * @param value the new message id
     */
    @JsonSetter("message_id")
    public void setMessageId (UUID value) { 
        this.messageId = value;
    }
 
    /**
     *  GETTER
     * The status of the message.
     *
     * @return the status
     */
    @JsonGetter("status")
    public StatusEnum getStatus ( ) { 
        return this.status;
    }
    
    /**
     *  SETTER
     * The status of the message.
     *
     * @param value the new status
     */
    @JsonSetter("status")
    public void setStatus (StatusEnum value) { 
        this.status = value;
    }
 
}
