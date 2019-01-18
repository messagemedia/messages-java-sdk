/*
 * MessageMediaMessages
 *
 */
package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class SendMessagesResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5000835389418531087L;
    private List<Object> messages;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("messages")
    public List<Object> getMessages ( ) { 
        return this.messages;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("messages")
    public void setMessages (List<Object> value) { 
        this.messages = value;
    }
 
}
 