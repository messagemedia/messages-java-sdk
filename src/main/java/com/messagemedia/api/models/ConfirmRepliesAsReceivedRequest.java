/*
 * MessagesLib
 *
 * This file was automatically generated by APIMATIC v3.0 ( https://www.apimatic.io ).
 */

package com.messagemedia.api.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

/**
 * This is a model class for ConfirmRepliesAsReceivedRequest type.
 */
public class ConfirmRepliesAsReceivedRequest {
    private List<String> replyIds;

    /**
     * Default constructor.
     */
    public ConfirmRepliesAsReceivedRequest() {
    }

    /**
     * Initialization constructor.
     * @param  replyIds  List of String value for replyIds.
     */
    public ConfirmRepliesAsReceivedRequest(
            List<String> replyIds) {
        this.replyIds = replyIds;
    }

    /**
     * Getter for ReplyIds.
     * @return Returns the List of String
     */
    @JsonGetter("reply_ids")
    public List<String> getReplyIds() {
        return replyIds;
    }

    /**
     * Setter for ReplyIds.
     * @param replyIds Value for List of String
     */
    @JsonSetter("reply_ids")
    public void setReplyIds(List<String> replyIds) {
        this.replyIds = replyIds;
    }

    /**
     * Converts this ConfirmRepliesAsReceivedRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ConfirmRepliesAsReceivedRequest [" + "replyIds=" + replyIds + "]";
    }

    /**
     * Builds a new {@link ConfirmRepliesAsReceivedRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ConfirmRepliesAsReceivedRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(replyIds);
        return builder;
    }

    /**
     * Class to build instances of {@link ConfirmRepliesAsReceivedRequest}.
     */
    public static class Builder {
        private List<String> replyIds;

        /**
         * Initialization constructor.
         */
        public Builder() {
        }

        /**
         * Initialization constructor.
         * @param  replyIds  List of String value for replyIds.
         */
        public Builder(List<String> replyIds) {
            this.replyIds = replyIds;
        }

        /**
         * Setter for replyIds.
         * @param  replyIds  List of String value for replyIds.
         * @return Builder
         */
        public Builder replyIds(List<String> replyIds) {
            this.replyIds = replyIds;
            return this;
        }

        /**
         * Builds a new {@link ConfirmRepliesAsReceivedRequest} object using the set fields.
         * @return {@link ConfirmRepliesAsReceivedRequest}
         */
        public ConfirmRepliesAsReceivedRequest build() {
            return new ConfirmRepliesAsReceivedRequest(replyIds);
        }
    }
}