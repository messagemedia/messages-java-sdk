/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.messagemedia.messages.DateTimeHelper;
import org.joda.time.DateTime;

public class Reply 
        implements java.io.Serializable {
    private static final long serialVersionUID = -7192913725110596203L;
    private String callbackUrl;
    private String content;
    private DateTime dateReceived;
    private String destinationNumber;
    private UUID messageId;
    private Object metadata;
    private UUID replyId;
    private String sourceNumber;
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
     * Content of the reply
     */
    @JsonGetter("content")
    public String getContent ( ) { 
        return this.content;
    }
    
    /** SETTER
     * Content of the reply
     */
    @JsonSetter("content")
    public void setContent (String value) { 
        this.content = value;
    }
 
    /** GETTER
     * Date time when the reply was received
     */
    @JsonGetter("date_received")
    @JsonSerialize(using=DateTimeHelper.Rfc8601DateTimeSerializer.class)
    public DateTime getDateReceived ( ) { 
        return this.dateReceived;
    }
    
    /** SETTER
     * Date time when the reply was received
     */
    @JsonSetter("date_received")
    @JsonDeserialize(using=DateTimeHelper.Rfc8601DateTimeDeserializer.class)
    public void setDateReceived (DateTime value) { 
        this.dateReceived = value;
    }
 
    /** GETTER
     * Address from which this reply was sent to
     */
    @JsonGetter("destination_number")
    public String getDestinationNumber ( ) { 
        return this.destinationNumber;
    }
    
    /** SETTER
     * Address from which this reply was sent to
     */
    @JsonSetter("destination_number")
    public void setDestinationNumber (String value) { 
        this.destinationNumber = value;
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
     * Unique ID of this reply
     */
    @JsonGetter("reply_id")
    public UUID getReplyId ( ) { 
        return this.replyId;
    }
    
    /** SETTER
     * Unique ID of this reply
     */
    @JsonSetter("reply_id")
    public void setReplyId (UUID value) { 
        this.replyId = value;
    }
 
    /** GETTER
     * Address from which this reply was received from
     */
    @JsonGetter("source_number")
    public String getSourceNumber ( ) { 
        return this.sourceNumber;
    }
    
    /** SETTER
     * Address from which this reply was received from
     */
    @JsonSetter("source_number")
    public void setSourceNumber (String value) { 
        this.sourceNumber = value;
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
