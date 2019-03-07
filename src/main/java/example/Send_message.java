package example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.messagemedia.messages.MessageMediaMessagesClient;
import com.messagemedia.messages.controllers.MessagesController;
import com.messagemedia.messages.models.SendMessagesRequest;


public class Send_message {

    public static void main(String[] args) throws Throwable {
        // Configuration parameters and credentials
        String authUserName = "API_KEY"; // The username to use with basic/HMAC authentication
        String authPassword = "API_SECRET"; // The password to use with basic/HMAC authentication
        boolean useHmacAuth = false; // Change to true if you are using HMAC keys

        MessageMediaMessagesClient client = new MessageMediaMessagesClient(authUserName, authPassword, useHmacAuth);
        MessagesController messages = client.getMessages();

        String bodyValue = "{\"messages\":" +
                "[{\"content\":\"Greeting from MessageMedia!\", " +
                "\"destination_number\":\"DESTINATION_NUMBER\"" +
                "}]}";

        SendMessagesRequest request = new SendMessagesRequest();

        ObjectMapper mapper = new ObjectMapper();
        SendMessagesRequest body = mapper.readValue(bodyValue,new TypeReference<SendMessagesRequest>(){});

        messages.createSendMessages(body);

    }

}
