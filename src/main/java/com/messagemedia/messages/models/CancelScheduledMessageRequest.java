package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class CancelScheduledMessageRequest.
 */
public class CancelScheduledMessageRequest 
        implements java.io.Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -39257300750867950L;
    
    /** The status. */
    private String status = "cancelled";
    
    /**
     *  GETTER
     * TODO: Write general description for this method.
     *
     * @return the status
     */
    @JsonGetter("status")
    public String getStatus ( ) { 
        return this.status;
    }
    
    /**
     *  SETTER
     * TODO: Write general description for this method.
     *
     * @param value the new status
     */
    @JsonSetter("status")
    public void setStatus (String value) { 
        this.status = value;
    }
 
}
