package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfirmRepliesAsReceivedRequest.
 */
public class ConfirmRepliesAsReceivedRequest 
        implements java.io.Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 89430737967238397L;
    
    /** The reply ids. */
    private List<String> replyIds;
    
    /**
     *  GETTER
     * TODO: Write general description for this method.
     *
     * @return the reply ids
     */
    @JsonGetter("reply_ids")
    public List<String> getReplyIds ( ) { 
        return this.replyIds;
    }
    
    /**
     *  SETTER
     * TODO: Write general description for this method.
     *
     * @param value the new reply ids
     */
    @JsonSetter("reply_ids")
    public void setReplyIds (List<String> value) { 
        this.replyIds = value;
    }
 
}
