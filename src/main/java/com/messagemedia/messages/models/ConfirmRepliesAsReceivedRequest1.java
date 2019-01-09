/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ConfirmRepliesAsReceivedRequest1 
        implements java.io.Serializable {
    private static final long serialVersionUID = -20224318760008146L;
    private List<UUID> replyIds;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("reply_ids")
    public List<UUID> getReplyIds ( ) { 
        return this.replyIds;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("reply_ids")
    public void setReplyIds (List<UUID> value) { 
        this.replyIds = value;
    }
 
}
