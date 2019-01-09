/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CheckRepliesResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -7772933677948924L;
    private List<Reply> replies;
    /** GETTER
     * The oldest 100 unconfirmed replies
     */
    @JsonGetter("replies")
    public List<Reply> getReplies ( ) { 
        return this.replies;
    }
    
    /** SETTER
     * The oldest 100 unconfirmed replies
     */
    @JsonSetter("replies")
    public void setReplies (List<Reply> value) { 
        this.replies = value;
    }
 
}
