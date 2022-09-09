
# Send Messages Request

## Structure

`SendMessagesRequest`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `Messages` | [`List<Message>`](../../doc/models/message.md) | Required | - | List<Message> getMessages() | setMessages(List<Message> messages) |

## Example (as JSON)

```json
{
  "messages": {
    "content": "Hello world!",
    "destination_number": "+61491570156"
  }
}
```

