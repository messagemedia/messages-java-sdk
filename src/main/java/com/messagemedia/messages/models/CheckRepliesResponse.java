package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckRepliesResponse.
 */
public class CheckRepliesResponse 
        implements java.io.Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7772933677948924L;
    
    /** The replies. */
    private List<Reply> replies;
    
    /**
     *  GETTER
     * The oldest 100 unconfirmed replies.
     *
     * @return the replies
     */
    @JsonGetter("replies")
    public List<Reply> getReplies ( ) { 
        return this.replies;
    }
    
    /**
     *  SETTER
     * The oldest 100 unconfirmed replies.
     *
     * @param value the new replies
     */
    @JsonSetter("replies")
    public void setReplies (List<Reply> value) { 
        this.replies = value;
    }
 
}
