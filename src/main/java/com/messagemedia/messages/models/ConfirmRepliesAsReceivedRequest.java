/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ConfirmRepliesAsReceivedRequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5531919675175769957L;
    private List<String> replyIds;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("reply_ids")
    public List<String> getReplyIds ( ) { 
        return this.replyIds;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("reply_ids")
    public void setReplyIds (List<String> value) { 
        this.replyIds = value;
    }
 
}
 