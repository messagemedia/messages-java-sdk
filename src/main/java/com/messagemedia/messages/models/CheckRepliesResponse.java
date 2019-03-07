package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class CheckRepliesResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -7772933677948924L;
    private List<Reply> replies;

    @JsonGetter("replies")
    public List<Reply> getReplies ( ) { 
        return this.replies;
    }
    
  
    @JsonSetter("replies")
    public void setReplies (List<Reply> value) { 
        this.replies = value;
    }
 
}
