package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class SendMessagesResponse.
 */
public class SendMessagesResponse 
        implements java.io.Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -119385951811053717L;
    
    /** The messages. */
    private List<Message> messages;
    
    /**
     *  GETTER
     * TODO: Write general description for this method.
     *
     * @return the messages
     */
    @JsonGetter("messages")
    public List<Message> getMessages ( ) { 
        return this.messages;
    }
    
    /**
     *  SETTER
     * TODO: Write general description for this method.
     *
     * @param value the new messages
     */
    @JsonSetter("messages")
    public void setMessages (List<Message> value) { 
        this.messages = value;
    }
 
}
