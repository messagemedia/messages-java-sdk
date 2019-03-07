package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ConfirmRepliesAsReceivedRequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = 89430737967238397L;
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
