# MessageMedia Messages Java SDK
[![Travis Build Status](https://api.travis-ci.org/messagemedia/messages-java-sdk.svg?branch=master)](https://travis-ci.org/messagemedia/messages-java-sdk)
[![maven](https://img.shields.io/badge/maven-v1.0.0-blue.svg)](https://mvnrepository.com/artifact/com.messagemedia.sdk/messages)

The MessageMedia Messages API provides a number of endpoints for building powerful two-way messaging applications.

## ⭐️ Installing via Maven
At present the jars are available from a public maven repository.

Use the following dependency in your project to grab via Maven:
```
<dependency>
    <groupId>com.messagemedia.sdk</groupId>
    <artifactId>messages</artifactId>
    <version>1.0.0</version>
</dependency>

```

## 🎬 Get Started
It's easy to get started. Simply enter the API Key and secret you obtained from the [MessageMedia Developers Portal](https://developers.messagemedia.com) into the code snippet below and a mobile number you wish to send to.

### 🚀 Send an SMS
* Destination numbers (`destination_number`) should be in the [E.164](http://en.wikipedia.org/wiki/E.164) format. For example, `+61491570156`.
```java
package com.company;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.messagemedia.messages.MessageMediaMessagesClient;
import com.messagemedia.messages.controllers.MessagesController;
import com.messagemedia.messages.models.SendMessagesRequest;
import com.fasterxml.jackson.core.type.TypeReference;

public class Main {

    public static void main(String[] args) throws Throwable {
        // Configuration parameters and credentials
        String authUserName = "API_KEY"; // The username to use with basic/HMAC authentication
        String authPassword = "API_SECRET"; // The password to use with basic/HMAC authentication
        boolean useHmacAuth = false; // Change to true if you are using HMAC keys

        MessageMediaMessagesClient client = new MessageMediaMessagesClient(authUserName, authPassword, useHmacAuth);
        MessagesController messages = client.getMessages();

        String bodyValue = "{\"messages\":" +
                "[{\"content\":\"My first message\", " +
                "\"destination_number\":\"YOUR_MOBILE_NUMBER\"" +
                "}]}";

        SendMessagesRequest request = new SendMessagesRequest();

        ObjectMapper mapper = new ObjectMapper();
        SendMessagesRequest body = mapper.readValue(bodyValue,new TypeReference<SendMessagesRequest> (){});


        messages.createSendMessages(body);

    }

}
```

### 🕓 Get Status of a Message
You can get a messsage ID from a sent message by looking at the `message_id` from the response of the above example.
```java
package com.company;
import com.messagemedia.messages.MessageMediaMessagesClient;
import com.messagemedia.messages.controllers.MessagesController;

public class Main {

    public static void main(String[] args) throws Throwable {
        // Configuration parameters and credentials
        String authUserName = "API_KEY"; // The username to use with basic/HMAC authentication
        String authPassword = "API_SECRET"; // The password to use with basic/HMAC authentication
        boolean useHmacAuth = false; // Change to true if you are using HMAC keys

        MessageMediaMessagesClient client = new MessageMediaMessagesClient(authUserName, authPassword, useHmacAuth);
        MessagesController messages = client.getMessages();

        MessagesController messages = client.getMessages();

        String messageId = "YOUR_MESSAGE_ID";
        String result = messages.getMessageStatus(messageId).parseAsString();
        System.out.print(result);
    }

}
```

### 💬 Get replies to a message
You can check for replies that are sent to your messages
```java
package com.company;
import com.messagemedia.messages.MessageMediaMessagesClient;
import com.messagemedia.messages.controllers.RepliesController;

public class Main {

    public static void main(String[] args) throws Throwable {
        // Configuration parameters and credentials
        String authUserName = "API_KEY"; // The username to use with basic/HMAC authentication
        String authPassword = "API_SECRET"; // The password to use with basic/HMAC authentication
        boolean useHmacAuth = false; // Change to true if you are using HMAC keys

        MessageMediaMessagesClient client = new MessageMediaMessagesClient(authUserName, authPassword, useHmacAuth);
        MessagesController messages = client.getMessages();

        RepliesController replies = client.getReplies();

        String result = replies.getCheckReplies().getReplies().toString();
        System.out.print(result);
    }

}
```

### ✅ Check Delivery Reports
This endpoint allows you to check for delivery reports to inbound and outbound messages.
```java
package com.company;
import com.messagemedia.messages.MessageMediaMessagesClient;
import com.messagemedia.messages.controllers.DeliveryReportsController;

public class Main {

    public static void main(String[] args) throws Throwable {
        // Configuration parameters and credentials
        String authUserName = "API_KEY"; // The username to use with basic/HMAC authentication
        String authPassword = "API_SECRET"; // The password to use with basic/HMAC authentication
        boolean useHmacAuth = false; // Change to true if you are using HMAC keys

        MessageMediaMessagesClient client = new MessageMediaMessagesClient(authUserName, authPassword, useHmacAuth);
        MessagesController messages = client.getMessages();

        DeliveryReportsController deliveryReports = client.getDeliveryReports();

        String result = deliveryReports.getCheckDeliveryReports().getDeliveryReports().toString();
        System.out.print(result);
    }

}
```

## 📕 Documentation
Check out the [full API documentation](DOCUMENTATION.md) for more detailed information.

## 😕 Need help?
Please contact developer support at developers@messagemedia.com or check out the developer portal at [developers.messagemedia.com](https://developers.messagemedia.com/)

## 📃 License
Apache License. See the [LICENSE](LICENSE) file.
