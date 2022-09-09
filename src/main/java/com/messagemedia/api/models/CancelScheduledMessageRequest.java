/*
 * MessagesLib
 *
 * This file was automatically generated by APIMATIC v3.0 ( https://www.apimatic.io ).
 */

package com.messagemedia.api.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * This is a model class for CancelScheduledMessageRequest type.
 */
public class CancelScheduledMessageRequest {
    private String status;

    /**
     * Default constructor.
     */
    public CancelScheduledMessageRequest() {
    }

    /**
     * Initialization constructor.
     * @param  status  String value for status.
     */
    public CancelScheduledMessageRequest(
            String status) {
        this.status = status;
    }

    /**
     * Getter for Status.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    /**
     * Setter for Status.
     * @param status Value for String
     */
    @JsonSetter("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Converts this CancelScheduledMessageRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CancelScheduledMessageRequest [" + "status=" + status + "]";
    }

    /**
     * Builds a new {@link CancelScheduledMessageRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CancelScheduledMessageRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(status);
        return builder;
    }

    /**
     * Class to build instances of {@link CancelScheduledMessageRequest}.
     */
    public static class Builder {
        private String status;

        /**
         * Initialization constructor.
         */
        public Builder() {
        }

        /**
         * Initialization constructor.
         * @param  status  String value for status.
         */
        public Builder(String status) {
            this.status = status;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link CancelScheduledMessageRequest} object using the set fields.
         * @return {@link CancelScheduledMessageRequest}
         */
        public CancelScheduledMessageRequest build() {
            return new CancelScheduledMessageRequest(status);
        }
    }
}
