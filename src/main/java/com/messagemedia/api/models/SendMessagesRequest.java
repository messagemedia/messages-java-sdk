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
 * This is a model class for SendMessagesRequest type.
 */
public class SendMessagesRequest {
    private List<Message> messages;

    /**
     * Default constructor.
     */
    public SendMessagesRequest() {
    }

    /**
     * Initialization constructor.
     * @param  messages  List of Message value for messages.
     */
    public SendMessagesRequest(
            List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Getter for Messages.
     * @return Returns the List of Message
     */
    @JsonGetter("messages")
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Setter for Messages.
     * @param messages Value for List of Message
     */
    @JsonSetter("messages")
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Converts this SendMessagesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SendMessagesRequest [" + "messages=" + messages + "]";
    }

    /**
     * Builds a new {@link SendMessagesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SendMessagesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(messages);
        return builder;
    }

    /**
     * Class to build instances of {@link SendMessagesRequest}.
     */
    public static class Builder {
        private List<Message> messages;

        /**
         * Initialization constructor.
         */
        public Builder() {
        }

        /**
         * Initialization constructor.
         * @param  messages  List of Message value for messages.
         */
        public Builder(List<Message> messages) {
            this.messages = messages;
        }

        /**
         * Setter for messages.
         * @param  messages  List of Message value for messages.
         * @return Builder
         */
        public Builder messages(List<Message> messages) {
            this.messages = messages;
            return this;
        }

        /**
         * Builds a new {@link SendMessagesRequest} object using the set fields.
         * @return {@link SendMessagesRequest}
         */
        public SendMessagesRequest build() {
            return new SendMessagesRequest(messages);
        }
    }
}