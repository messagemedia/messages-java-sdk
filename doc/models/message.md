
# Message

## Structure

`Message`

## Fields

| Name | Type | Tags | Description | Getter | Setter |
|  --- | --- | --- | --- | --- | --- |
| `CallbackUrl` | `String` | Optional | URL replies and delivery reports to this message will be pushed to | String getCallbackUrl() | setCallbackUrl(String callbackUrl) |
| `Content` | `String` | Required | Content of the message<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `5000` | String getContent() | setContent(String content) |
| `DestinationNumber` | `String` | Required | Destination number of the message<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `15` | String getDestinationNumber() | setDestinationNumber(String destinationNumber) |
| `DeliveryReport` | `Boolean` | Optional | Request a delivery report for this message<br>**Default**: `false` | Boolean getDeliveryReport() | setDeliveryReport(Boolean deliveryReport) |
| `Format` | [`List<FormatEnum>`](../../doc/models/format-enum.md) | Optional | Format of message, SMS, MMS or TTS (Text To Speech). | List<FormatEnum> getFormat() | setFormat(List<FormatEnum> format) |
| `Media` | `List<String>` | Optional | - | List<String> getMedia() | setMedia(List<String> media) |
| `MessageExpiryTimestamp` | `LocalDateTime` | Optional | Date time after which the message expires and will not be sent | LocalDateTime getMessageExpiryTimestamp() | setMessageExpiryTimestamp(LocalDateTime messageExpiryTimestamp) |
| `Metadata` | `Object` | Optional | Metadata for the message specified as a set of key value pairs, each key can be up to 100 characters long and each value can be up to 256 characters long<br><br>```<br>{<br>   "myKey": "myValue",<br>   "anotherKey": "anotherValue"<br>}<br>``` | Object getMetadata() | setMetadata(Object metadata) |
| `Scheduled` | `LocalDateTime` | Optional | Scheduled delivery date time of the message | LocalDateTime getScheduled() | setScheduled(LocalDateTime scheduled) |
| `SourceNumber` | `String` | Optional | - | String getSourceNumber() | setSourceNumber(String sourceNumber) |
| `SourceNumberType` | [`SourceNumberTypeEnum`](../../doc/models/source-number-type-enum.md) | Optional | Type of source address specified, this can be INTERNATIONAL, ALPHANUMERIC or SHORTCODE | SourceNumberTypeEnum getSourceNumberType() | setSourceNumberType(SourceNumberTypeEnum sourceNumberType) |

## Example (as JSON)

```json
{
  "content": "Hello world!",
  "destination_number": "+61491570156"
}
```

