# Messages

```java
MessagesController messagesController = client.getMessagesController();
```

## Class Name

`MessagesController`

## Methods

* [Get Message Status](../../doc/controllers/messages.md#get-message-status)
* [Update Cancel Scheduled Message](../../doc/controllers/messages.md#update-cancel-scheduled-message)
* [Create Send Messages](../../doc/controllers/messages.md#create-send-messages)


# Get Message Status

Retrieve the current status of a message using the message ID returned in the send messages end point.
A successful request to the get message status endpoint will return a response body as follows:

```json
{
    "format": "SMS",
    "content": "My first message!",
    "metadata": {
        "key1": "value1",
        "key2": "value2"
    },
    "message_id": "877c19ef-fa2e-4cec-827a-e1df9b5509f7",
    "callback_url": "https://my.callback.url.com",
    "delivery_report": true,
    "destination_number": "+61401760575",
    "scheduled": "2016-11-03T11:49:02.807Z",
    "source_number": "+61491570157",
    "source_number_type": "INTERNATIONAL"
    "message_expiry_timestamp": "2016-11-03T11:49:02.807Z",
    "status": "enroute"
}
```

The status property of the response indicates the current status of the message. See the Delivery
Reports section of this documentation for more information on message statues.
*Note: If an invalid or non existent message ID parameter is specified in the request, then
a HTTP 404 Not Found response will be returned*

```java
CompletableFuture<DynamicResponse> getMessageStatusAsync(
    final String messageId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `messageId` | `String` | Template, Required | - |

## Response Type

`DynamicResponse`

## Example Usage

```java
String messageId = "messageId2";

messagesController.getMessageStatusAsync(messageId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Errors

| HTTP Status Code | Error Description | Exception Class |
|  --- | --- | --- |
| 404 | - | `ApiException` |


# Update Cancel Scheduled Message

Cancel a scheduled message that has not yet been delivered.
A scheduled message can be cancelled by updating the status of a message from `scheduled`
to `cancelled`. This is done by submitting a PUT request to the messages endpoint using
the message ID as a parameter (the same endpoint used above to retrieve the status of a message).
The body of the request simply needs to contain a `status` property with the value set
to `cancelled`.

```json
{
    "status": "cancelled"
}
```

*Note: Only messages with a status of scheduled can be cancelled. If an invalid or non existent
message ID parameter is specified in the request, then a HTTP 404 Not Found response will be
returned*

```java
CompletableFuture<DynamicResponse> updateCancelScheduledMessageAsync(
    final String messageId,
    final String contentType,
    final CancelScheduledMessageRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `messageId` | `String` | Template, Required | - |
| `contentType` | `String` | Header, Required | - |
| `body` | [`CancelScheduledMessageRequest`](../../doc/models/cancel-scheduled-message-request.md) | Body, Required | - |

## Response Type

`DynamicResponse`

## Example Usage

```java
String messageId = "messageId2";
String contentType = "application/json";
CancelScheduledMessageRequest body = new CancelScheduledMessageRequest();
body.setStatus("status2");

messagesController.updateCancelScheduledMessageAsync(messageId, contentType, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Errors

| HTTP Status Code | Error Description | Exception Class |
|  --- | --- | --- |
| 400 | - | `ApiException` |
| 404 | - | `ApiException` |


# Create Send Messages

Submit one or more (up to 100 per request) SMS or text to voice messages for delivery.

```java
CompletableFuture<DynamicResponse> createSendMessagesAsync(
    final SendMessagesRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SendMessagesRequest`](../../doc/models/send-messages-request.md) | Body, Required | - |

## Server

`Server.`

## Response Type

`DynamicResponse`

## Example Usage

```java
SendMessagesRequest body = new SendMessagesRequest();
body.setMessages(new LinkedList<>());

Message bodyMessages0 = new Message();
bodyMessages0.setContent("Hello world!");
bodyMessages0.setDestinationNumber("+61491570156");
body.getMessages().add(bodyMessages0);


messagesController.createSendMessagesAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Example Response

```
{
  "messages": [
    {
      "message_id": "04fe9a97-a579-43c5-bb1a-58ed29bf0a6a",
      "callback_url": "https://my.url.com",
      "status": "delivered",
      "content": "My first message",
      "destination_number": "+61491570156",
      "delivery_report": true,
      "format": "SMS",
      "message_expiry_timestamp": "2016-11-03T11:49:02.807Z",
      "metadata": {
        "key1": "value1",
        "key2": "value2"
      },
      "scheduled": "2016-11-03T11:49:02.807Z",
      "source_number": "+61491570157",
      "source_number_type": "INTERNATIONAL"
    }
  ]
}
```

## Errors

| HTTP Status Code | Error Description | Exception Class |
|  --- | --- | --- |
| 400 | Error | `ApiException` |

