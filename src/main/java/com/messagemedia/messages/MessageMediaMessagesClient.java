/*
 * MessageMediaMessages
 *
 * This file was automatically generated for MessageMedia by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.messagemedia.messages;

import com.messagemedia.messages.controllers.*;
import com.messagemedia.messages.http.client.HttpClient;

public class MessageMediaMessagesClient {
    /**
     * Singleton access to Messages controller
     * @return	Returns the MessagesController instance 
     */
    public MessagesController getMessages() {
        return MessagesController.getInstance();
    }

    /**
     * Singleton access to DeliveryReports controller
     * @return	Returns the DeliveryReportsController instance 
     */
    public DeliveryReportsController getDeliveryReports() {
        return DeliveryReportsController.getInstance();
    }

    /**
     * Singleton access to Replies controller
     * @return	Returns the RepliesController instance 
     */
    public RepliesController getReplies() {
        return RepliesController.getInstance();
    }

    /**
     * Get the shared http client currently being used for API calls
     * @return The http client instance currently being used
     */
    public HttpClient getSharedHttpClient() {
        return BaseController.getClientInstance();
    }
    
    /**
     * Set a shared http client to be used for API calls
     * @param httpClient The http client to use
     */
    public void setSharedHttpClient(HttpClient httpClient) {
        BaseController.setClientInstance(httpClient);
    }

    /**
     * Default constructor 
     */     
    public MessageMediaMessagesClient() {
    }

    /**
     * Client initialization constructor 
     */     
    public MessageMediaMessagesClient(String authUserName, String authPassword, boolean hmacAuth) {
        if(!hmacAuth)
        {
            //this();
            Configuration.basicAuthUserName = authUserName;
            Configuration.basicAuthPassword = authPassword;
        }
        else
        {
            Configuration.hmacAuthUserName = authUserName;
            Configuration.hmacAuthPassword = authPassword;
        }
    }
}