package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class SendMessagesResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -119385951811053717L;
    private List<Message> messages;

    @JsonGetter("messages")
    public List<Message> getMessages ( ) { 
        return this.messages;
    }
    

    @JsonSetter("messages")
    public void setMessages (List<Message> value) { 
        this.messages = value;
    }
 
}
