package com.messagemedia.messages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateTimeHelper {

    private static final DateTimeFormatter RFC1123_DATE_TIME_FORMATTER = 
            DateTimeFormat.forPattern("EEE, dd MMM yyyy HH:mm:ss z")
            .withZone(DateTimeZone.forID("GMT"));


    public static DateTime fromUnixTimestamp(Long date) {
        return new DateTime(date * 1000l);
    }

  
    public static DateTime fromUnixTimestamp(String date) {
        return new DateTime(Long.parseLong(date) * 1000l);
    }

  
    public static String toUnixTimestamp(DateTime value) {
        return Long.toString(value.getMillis() / 1000l);
    }


    public static List<String> toUnixTimestamp(List<DateTime> values) {
        if(values == null)
            return null;

        List<String> valuesAsString = new ArrayList<String>();
        for (DateTime value: values) {
            valuesAsString.add(toUnixTimestamp(value));
        }
        return valuesAsString;
    }


    public static DateTime fromRfc1123DateTime(String date) {
        return RFC1123_DATE_TIME_FORMATTER.parseDateTime(date);
    }


    public static String toRfc1123DateTime(DateTime value) {
        return RFC1123_DATE_TIME_FORMATTER.print(value);
    }


    public static List<String> toRfc1123DateTime(List<DateTime> values) {
        if(values == null)
            return null;

        List<String> valuesAsString = new ArrayList<String>();
        for (DateTime value: values) {
            valuesAsString.add(toRfc1123DateTime(value));
        }
        return valuesAsString;
    }


    public static DateTime fromRfc8601DateTime(String date) {
        try {
            return new DateTime(date, DateTimeZone.UTC);
        } catch  (IllegalArgumentException e) {
            throw new IllegalArgumentException("The value '" + date + "' was not a valid RFC3339 datetime string.", e);
        }
    }


    public static String toRfc8601DateTime(DateTime value) {
        return value.toString();
    }

  
    public static List<String> toRfc8601DateTime(List<DateTime> values) {
        if(values == null)
            return null;

        List<String> valuesAsString = new ArrayList<String>();
        for (DateTime value: values) {
            valuesAsString.add(toRfc8601DateTime(value));
        }
        return valuesAsString;
    }


    public static LocalDate fromSimpleDate(String date) {
        return new LocalDate(date);
    }
    

    public static String toSimpleDate(LocalDate value) {
        return value.toString();
    }


    public static List<String> toSimpleDate(List<LocalDate> values) {
        if(values == null)
            return null;
        
        List<String> valuesAsString = new ArrayList<String>();
        for (LocalDate value: values) {
            valuesAsString.add(toSimpleDate(value));
        }
        return valuesAsString;
    }


    public static class UnixTimestampDeserializer extends JsonDeserializer<DateTime> {
        @Override
        public DateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return fromUnixTimestamp(jp.getValueAsString());
        }
    }


    public static class UnixTimestampSerializer extends JsonSerializer<DateTime> {
        @Override
        public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeNumber(toUnixTimestamp(value));
        }
    }


    public static class Rfc1123DateTimeDeserializer extends JsonDeserializer<DateTime> {
        @Override
        public DateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return fromRfc1123DateTime(jp.getValueAsString());
        }
    }


    public static class Rfc1123DateTimeSerializer extends JsonSerializer<DateTime> {
        @Override
        public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeString(toRfc1123DateTime(value));
        }
    }


    public static class Rfc8601DateTimeDeserializer extends JsonDeserializer<DateTime> {
        @Override
        public DateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return fromRfc8601DateTime(jp.getValueAsString());
        }
    }

 
    public static class Rfc8601DateTimeSerializer extends JsonSerializer<DateTime> {
        @Override
        public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeString(toRfc8601DateTime(value));
        }
    }
    

    public static class SimpleDateDeserializer extends JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return fromSimpleDate(jp.getValueAsString());
        }
    }
    

    public static class SimpleDateSerializer extends JsonSerializer<LocalDate> {
        @Override
        public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeString(toSimpleDate(value));
        }
    }
}