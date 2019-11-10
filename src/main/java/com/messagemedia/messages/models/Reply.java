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
 * The Class Reply.
 */
public class Reply 
        implements java.io.Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7192913725110596203L;
    
    /** The callback url. */
    private String callbackUrl;
    
    /** The content. */
    private String content;
    
    /** The date received. */
    private DateTime dateReceived;
    
    /** The destination number. */
    private String destinationNumber;
    
    /** The message id. */
    private UUID messageId;
    
    /** The metadata. */
    private Object metadata;
    
    /** The reply id. */
    private UUID replyId;
    
    /** The source number. */
    private String sourceNumber;
    
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
     * Content of the reply.
     *
     * @return the content
     */
    @JsonGetter("content")
    public String getContent ( ) { 
        return this.content;
    }
    
    /**
     *  SETTER
     * Content of the reply.
     *
     * @param value the new content
     */
    @JsonSetter("content")
    public void setContent (String value) { 
        this.content = value;
    }
 
    /**
     *  GETTER
     * Date time when the reply was received.
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
     * Date time when the reply was received.
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
     * Address from which this reply was sent to.
     *
     * @return the destination number
     */
    @JsonGetter("destination_number")
    public String getDestinationNumber ( ) { 
        return this.destinationNumber;
    }
    
    /**
     *  SETTER
     * Address from which this reply was sent to.
     *
     * @param value the new destination number
     */
    @JsonSetter("destination_number")
    public void setDestinationNumber (String value) { 
        this.destinationNumber = value;
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
     * Unique ID of this reply.
     *
     * @return the reply id
     */
    @JsonGetter("reply_id")
    public UUID getReplyId ( ) { 
        return this.replyId;
    }
    
    /**
     *  SETTER
     * Unique ID of this reply.
     *
     * @param value the new reply id
     */
    @JsonSetter("reply_id")
    public void setReplyId (UUID value) { 
        this.replyId = value;
    }
 
    /**
     *  GETTER
     * Address from which this reply was received from.
     *
     * @return the source number
     */
    @JsonGetter("source_number")
    public String getSourceNumber ( ) { 
        return this.sourceNumber;
    }
    
    /**
     *  SETTER
     * Address from which this reply was received from.
     *
     * @param value the new source number
     */
    @JsonSetter("source_number")
    public void setSourceNumber (String value) { 
        this.sourceNumber = value;
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
