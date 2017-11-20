/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages.models;

import java.util.*;

public class CheckRepliesResponseBuilder {
    //the instance to build
    private CheckRepliesResponse checkRepliesResponse;

    /**
     * Default constructor to initialize the instance
     */
    public CheckRepliesResponseBuilder() {
        checkRepliesResponse = new CheckRepliesResponse();
    }

    public CheckRepliesResponseBuilder replies(List<Object> replies) {
        checkRepliesResponse.setReplies(replies);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public CheckRepliesResponse build() {
        return checkRepliesResponse;
    }
}