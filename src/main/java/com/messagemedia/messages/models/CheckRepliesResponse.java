/*
 * MessageMediaMessages
 *
 */
package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CheckRepliesResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5152723690941598473L;
    private List<Object> replies;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("replies")
    public List<Object> getReplies ( ) { 
        return this.replies;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("replies")
    public void setReplies (List<Object> value) { 
        this.replies = value;
    }
 
}
 