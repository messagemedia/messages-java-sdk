package com.messagemedia.messages.models;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckRepliesResponseBuilder.
 */
public class CheckRepliesResponseBuilder {
    
    /** The check replies response. */
    //the instance to build
    private CheckRepliesResponse checkRepliesResponse;

    /**
     * Default constructor to initialize the instance.
     */
    public CheckRepliesResponseBuilder() {
        checkRepliesResponse = new CheckRepliesResponse();
    }

    /**
     * The oldest 100 unconfirmed replies.
     *
     * @param replies the replies
     * @return the check replies response builder
     */
    public CheckRepliesResponseBuilder replies(List<Reply> replies) {
        checkRepliesResponse.setReplies(replies);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the check replies response
     */
    public CheckRepliesResponse build() {
        return checkRepliesResponse;
    }
}