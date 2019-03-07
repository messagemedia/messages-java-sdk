package com.messagemedia.messages;

import com.messagemedia.messages.controllers.*;
import com.messagemedia.messages.http.client.HttpClient;

public class MessageMediaMessagesClient {

    public MessagesController getMessages() {
        return MessagesController.getInstance();
    }


    public DeliveryReportsController getDeliveryReports() {
        return DeliveryReportsController.getInstance();
    }


    public RepliesController getReplies() {
        return RepliesController.getInstance();
    }

 
    public HttpClient getSharedHttpClient() {
        return BaseController.getClientInstance();
    }
    

    public void setSharedHttpClient(HttpClient httpClient) {
        BaseController.setClientInstance(httpClient);
    }


    public MessageMediaMessagesClient(String authUserName, String authPassword, boolean hmacAuth) {
        if(!hmacAuth)
        {
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