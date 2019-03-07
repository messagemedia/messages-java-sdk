package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class CancelScheduledMessageRequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = -39257300750867950L;
    private String status = "cancelled";

    @JsonGetter("status")
    public String getStatus ( ) { 
        return this.status;
    }
    

    @JsonSetter("status")
    public void setStatus (String value) { 
        this.status = value;
    }
 
}
