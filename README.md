# MessageMedia Messages Java SDK
[![Pull Requests Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat)](http://makeapullrequest.com)
[![maven](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/messagemedia/sdk/messages/maven-metadata.xml.svg)](https://mvnrepository.com/artifact/com.messagemedia.sdk/messages)

The MessageMedia Messages API provides a number of endpoints for building powerful two-way messaging applications.

![Isometric](https://i.imgur.com/jJeHwf5.png)

## Table of Contents
* [Authentication](#closed_lock_with_key-authentication)
* [Errors](#interrobang-errors)
* [Information](#newspaper-information)
  * [Slack and Mailing List](#slack-and-mailing-list)
  * [Bug Reports](#bug-reports)
  * [Contributing](#contributing)
* [Installation](#star-installation)
* [Get Started](#clapper-get-started)
* [API Documentation](#closed_book-api-documentation)
* [Need help?](#confused-need-help)
* [License](#page_with_curl-license)

## :closed_lock_with_key: Authentication

Authentication is done via API keys. Sign up at https://developers.messagemedia.com/register/ to get your API keys.

Requests are authenticated using HTTP Basic Auth or HMAC. Provide your API key as the auth_user_name and API secret as the auth_password.

## :interrobang: Errors

Our API returns standard HTTP success or error status codes. For errors, we will also include extra information about what went wrong encoded in the response as JSON. The most common status codes are listed below.

#### HTTP Status Codes

| Code      | Title       | Description |
|-----------|-------------|-------------|
| 400 | Invalid Request | The request was invalid |
| 401 | Unauthorized | Your API credentials are invalid |
| 403 | Disabled feature | Feature not enabled |
| 404 | Not Found |	The resource does not exist |
| 50X | Internal Server Error | An error occurred with our API |

## :newspaper: Information

#### Slack and Mailing List

If you have any questions, comments, or concerns, please join our Slack channel:
https://developers.messagemedia.com/collaborate/slack/

Alternatively you can email us at:
developers@messagemedia.com

#### Bug reports

If you discover a problem with the SDK, we would like to know about it. You can raise an [issue](https://github.com/messagemedia/signingkeys-nodejs-sdk/issues) or send an email to: developers@messagemedia.com

#### Contributing

We welcome your thoughts on how we could best provide you with SDKs that would simplify how you consume our services in your application. You can fork and create pull requests for any features you would like to see or raise an [issue](https://github.com/messagemedia/signingkeys-nodejs-sdk/issues)

## :star: Installation
At present the jars are available from a public maven repository.

Use the following dependency in your project to grab via Maven:
```
<dependency>
  <groupId>com.messagemedia.sdk</groupId>
  <artifactId>messages</artifactId>
  <version>2.0.0</version>
</dependency>

```

## :clapper: Get Started
It's easy to get started. Simply enter the API Key and secret you obtained from the [MessageMedia Developers Portal](https://developers.messagemedia.com) into the code snippet below and a mobile number you wish to send to.

### Send an SMS
Destination numbers (`destination_number`) should be in the [E.164](http://en.wikipedia.org/wiki/E.164) format. For example, `+61491570156`.
```java
import java.util.ArrayList;
import java.util.List;

import com.messagemedia.messages.MessageMediaMessagesClient;
import com.messagemedia.messages.controllers.MessagesController;
import com.messagemedia.messages.http.client.APICallBack;
import com.messagemedia.messages.http.client.HttpContext;
import com.messagemedia.messages.models.Message;
import com.messagemedia.messages.models.SendMessagesRequest;
import com.messagemedia.messages.models.SendMessagesResponse;

public class App
{
    public static void main( String[] args )
    {

     // Configuration parameters and credentials
        String authUserName = "API_KEY"; // The username to use with basic/HMAC authentication
        String authPassword = "API_SECRET"; // The password to use with basic/HMAC authentication
        boolean useHmacAuth = false; // Change to true if you are using HMAC keys

        MessageMediaMessagesClient client = new MessageMediaMessagesClient(authUserName, authPassword, useHmacAuth);
        MessagesController messages = client.getMessages();

        Message message = new Message();
        message.setContent("My message");
        message.setDestinationNumber("+61466412529");

        List<Message> messagesList = new ArrayList<Message>();
        messagesList.add(message);

        SendMessagesRequest body = new SendMessagesRequest();
        body.setMessages(messagesList);
        
      //load all optional headers for the outgoing API request
        Map<String, String> optHeaders = new HashMap<String, String>();
        optHeaders.put("Account", "");

        messages.sendMessagesAsync(body, optHeaders, new APICallBack<SendMessagesResponse>() {
		        public void onSuccess(HttpContext context, SendMessagesResponse response) {
		            // TODO success callback handler
		        	System.out.println("success");
		        }
		        public void onFailure(HttpContext context, Throwable error) {
		            // TODO failure callback handler
		        	System.out.println("failure");
		        }
			});
    }
}
```

### Send an MMS
* Destination numbers (`destination_number`) should be in the [E.164](http://en.wikipedia.org/wiki/E.164) format. For example, `+61491570156`.
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.messagemedia.messages.MessageMediaMessagesClient;
import com.messagemedia.messages.controllers.MessagesController;
import com.messagemedia.messages.http.client.APICallBack;
import com.messagemedia.messages.http.client.HttpContext;
import com.messagemedia.messages.models.FormatEnum;
import com.messagemedia.messages.models.Message;
import com.messagemedia.messages.models.SendMessagesRequest;
import com.messagemedia.messages.models.SendMessagesResponse;

public class App
{
    public static void main( String[] args )
    {

     // Configuration parameters and credentials
        String authUserName = "API_KEY"; // The username to use with basic/HMAC authentication
        String authPassword = "API_SECRET"; // The password to use with basic/HMAC authentication
        boolean useHmacAuth = false; // Change to true if you are using HMAC keys

        MessageMediaMessagesClient client = new MessageMediaMessagesClient(authUserName, authPassword, useHmacAuth);
        MessagesController messages = client.getMessages();

        Message message = new Message();
        message.setContent("My message");
        message.setDestinationNumber("+61466412529");
        message.setFormat(FormatEnum.MMS);
        message.setSubject("This is an MMS");
        message.setMedia(new ArrayList<String>(Arrays.asList("https://upload.wikimedia.org/wikipedia/commons/6/6a/L80385-flash-superhero-logo-1544.png")));


        List<Message> messagesList = new ArrayList<Message>();
        messagesList.add(message);

        SendMessagesRequest body = new SendMessagesRequest();
        body.setMessages(messagesList);

        messages.sendMessagesAsync(body, new APICallBack<SendMessagesResponse>() {
		        public void onSuccess(HttpContext context, SendMessagesResponse response) {
		            // TODO success callback handler
		        	System.out.println("success");
		        }
		        public void onFailure(HttpContext context, Throwable error) {
		            // TODO failure callback handler
		        	System.out.println("failure");
		        }
			});
    }
}
```

### Get Status of a Message
You can get a messsage ID from a sent message by looking at the `message_id` from the response of the above example.
```java
import com.messagemedia.messages.MessageMediaMessagesClient;
import com.messagemedia.messages.controllers.MessagesController;
import com.messagemedia.messages.http.client.APICallBack;
import com.messagemedia.messages.http.client.HttpContext;
import com.messagemedia.messages.models.GetMessageStatusResponse;

public class App {

    public static void main(String[] args) throws Throwable {
        // Configuration parameters and credentials
        String authUserName = "API_KEY"; // The username to use with basic/HMAC authentication
        String authPassword = "API_SECRET"; // The password to use with basic/HMAC authentication
        boolean useHmacAuth = false; // Change to true if you are using HMAC keys

        MessageMediaMessagesClient client = new MessageMediaMessagesClient(authUserName, authPassword, useHmacAuth);
        MessagesController messages = client.getMessages();

        String messageId = "YOUR_MESSAGE_ID";
        messages.getMessageStatusAsync(messageId, new APICallBack<GetMessageStatusResponse>() {
	        public void onSuccess(HttpContext context, GetMessageStatusResponse response) {
	            // TODO success callback handler
	        	System.out.println("success");
	        }
	        public void onFailure(HttpContext context, Throwable error) {
	            // TODO failure callback handler
	        	System.out.println("failure");
	        }
		});
    }

}
```

### Get replies to a message
You can check for replies that are sent to your messages
```java
import com.messagemedia.messages.MessageMediaMessagesClient;
import com.messagemedia.messages.controllers.MessagesController;
import com.messagemedia.messages.controllers.RepliesController;
import com.messagemedia.messages.http.client.APICallBack;
import com.messagemedia.messages.http.client.HttpContext;
import com.messagemedia.messages.models.CheckRepliesResponse;
import com.messagemedia.messages.models.GetMessageStatusResponse;

public class App {

    public static void main(String[] args) throws Throwable {
        // Configuration parameters and credentials
        String authUserName = "API_KEY"; // The username to use with basic/HMAC authentication
        String authPassword = "API_SECRET"; // The password to use with basic/HMAC authentication
        boolean useHmacAuth = false; // Change to true if you are using HMAC keys

        MessageMediaMessagesClient client = new MessageMediaMessagesClient(authUserName, authPassword, useHmacAuth);
        RepliesController replies = client.getReplies();

        replies.checkRepliesAsync(new APICallBack<CheckRepliesResponse>() {
	        public void onSuccess(HttpContext context, CheckRepliesResponse response) {
	            // TODO success callback handler
	        	System.out.println("success");
	        }
	        public void onFailure(HttpContext context, Throwable error) {
	            // TODO failure callback handler
	        	System.out.println("failure");
	        }
		});  

    }

}
```

### Check Delivery Reports
This endpoint allows you to check for delivery reports to inbound and outbound messages.
```java
import com.messagemedia.messages.MessageMediaMessagesClient;
import com.messagemedia.messages.controllers.DeliveryReportsController;
import com.messagemedia.messages.http.client.APICallBack;
import com.messagemedia.messages.http.client.HttpContext;
import com.messagemedia.messages.models.CheckDeliveryReportsResponse;


public class App
{
    public static void main( String[] args )
    {

     // Configuration parameters and credentials
        String authUserName = "API_KEY"; // The username to use with basic/HMAC authentication
        String authPassword = "API_SECRET"; // The password to use with basic/HMAC authentication
        boolean useHmacAuth = false; // Change to true if you are using HMAC keys

        MessageMediaMessagesClient client = new MessageMediaMessagesClient(authUserName, authPassword, useHmacAuth);
        DeliveryReportsController deliveryReports = client.getDeliveryReports();

        deliveryReports.checkDeliveryReportsAsync(new APICallBack<CheckDeliveryReportsResponse>() {
		        public void onSuccess(HttpContext context, CheckDeliveryReportsResponse response) {
		            // TODO success callback handler
		        	System.out.println("success");
		        }
		        public void onFailure(HttpContext context, Throwable error) {
		            // TODO failure callback handler
		        	System.out.println("failure");
		        }
			});
    }
}
```

### Confirm Delivery Reports
This endpoint allows you to mark delivery reports as confirmed so they're no longer returned by the Check Delivery Reports function.
```java
import java.util.ArrayList;
import java.util.List;

import com.messagemedia.messages.MessageMediaMessagesClient;
import com.messagemedia.messages.controllers.DeliveryReportsController;
import com.messagemedia.messages.http.client.APICallBack;
import com.messagemedia.messages.http.client.HttpContext;
import com.messagemedia.messages.models.CheckDeliveryReportsResponse;
import com.messagemedia.messages.models.ConfirmDeliveryReportsAsReceivedRequest;
import com.messagemedia.messages.models.DynamicResponse;


public class App
{
    public static void main( String[] args )
    {

     // Configuration parameters and credentials
        String authUserName = "API_KEY"; // The username to use with basic/HMAC authentication
        String authPassword = "API_SECRET"; // The password to use with basic/HMAC authentication
        boolean useHmacAuth = false; // Change to true if you are using HMAC keys

        MessageMediaMessagesClient client = new MessageMediaMessagesClient(authUserName, authPassword, useHmacAuth);
        DeliveryReportsController deliveryReports = client.getDeliveryReports();

        ConfirmDeliveryReportsAsReceivedRequest body = new ConfirmDeliveryReportsAsReceivedRequest();
        List<String> reportIds = new ArrayList<String>();
        reportIds.add("delivery-report-id");

        deliveryReports.confirmDeliveryReportsAsReceivedAsync(body, new APICallBack<DynamicResponse>() {
		        public void onSuccess(HttpContext context, DynamicResponse response) {
		            // TODO success callback handler
		        	System.out.println("success");
		        }
		        public void onFailure(HttpContext context, Throwable error) {
		            // TODO failure callback handler
		        	System.out.println("failure");
		        }
			});
    }
}
```

### Check credits remaining (Prepaid accounts only)
This endpoint allows you to check for credits remaining on your prepaid account.
```java
import com.messagemedia.messages.MessageMediaMessagesClient;
import com.messagemedia.messages.controllers.MessagesController;
import com.messagemedia.messages.http.client.APICallBack;
import com.messagemedia.messages.http.client.HttpContext;
import com.messagemedia.messages.models.DynamicResponse;


public class App
{
    public static void main( String[] args )
    {

     // Configuration parameters and credentials
        String authUserName = "API_KEY"; // The username to use with basic/HMAC authentication
        String authPassword = "API_SECRET"; // The password to use with basic/HMAC authentication
        boolean useHmacAuth = false; // Change to true if you are using HMAC keys

        MessageMediaMessagesClient client = new MessageMediaMessagesClient(authUserName, authPassword, useHmacAuth);
        MessagesController messages = client.getMessages();
        
        messages.checkCreditsRemainingAsync(new APICallBack<DynamicResponse>() {
		        public void onSuccess(HttpContext context, DynamicResponse response) {
		            // TODO success callback handler
		        	System.out.println(response.toString());
		        }
		        public void onFailure(HttpContext context, Throwable error) {
		            // TODO failure callback handler
		        	System.out.println("failure");
		        }
			});
    }
}
```

## :closed_book: API Reference Documentation
Check out the [full API documentation](https://developers.messagemedia.com/code/messages-api-documentation/) for more detailed information.

## :confused: Need help?
Please contact developer support at developers@messagemedia.com or check out the developer portal at [developers.messagemedia.com](https://developers.messagemedia.com/)

## :page_with_curl: License
Apache License. See the [LICENSE](LICENSE) file.
