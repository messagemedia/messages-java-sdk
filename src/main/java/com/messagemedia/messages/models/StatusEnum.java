package com.messagemedia.messages.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum StatusEnum {
    ENROUTE, //TODO: Write general description for this element
    SUBMITTED, //TODO: Write general description for this element
    DELIVERED, //TODO: Write general description for this element
    EXPIRED, //TODO: Write general description for this element
    REJECTED, //TODO: Write general description for this element
    UNDELIVERABLE, //TODO: Write general description for this element
    QUEUED, //TODO: Write general description for this element
    PROCESSED, //TODO: Write general description for this element
    CANCELLED, //TODO: Write general description for this element
    SCHEDULED, //TODO: Write general description for this element
    FAILED; //TODO: Write general description for this element

    private static TreeMap<String, StatusEnum> valueMap = new TreeMap<String, StatusEnum>();
    private String value;

    static {
        ENROUTE.value = "enroute";
        SUBMITTED.value = "submitted";
        DELIVERED.value = "delivered";
        EXPIRED.value = "expired";
        REJECTED.value = "rejected";
        UNDELIVERABLE.value = "undeliverable";
        QUEUED.value = "queued";
        PROCESSED.value = "processed";
        CANCELLED.value = "cancelled";
        SCHEDULED.value = "scheduled";
        FAILED.value = "failed";

        valueMap.put("enroute", ENROUTE);
        valueMap.put("submitted", SUBMITTED);
        valueMap.put("delivered", DELIVERED);
        valueMap.put("expired", EXPIRED);
        valueMap.put("rejected", REJECTED);
        valueMap.put("undeliverable", UNDELIVERABLE);
        valueMap.put("queued", QUEUED);
        valueMap.put("processed", PROCESSED);
        valueMap.put("cancelled", CANCELLED);
        valueMap.put("scheduled", SCHEDULED);
        valueMap.put("failed", FAILED);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static StatusEnum fromString(String toConvert) {
        return valueMap.get(toConvert);
    }

    /**
     * Returns the string value associated with the enum member
     * @return The string value against enum member */
    @com.fasterxml.jackson.annotation.JsonValue
    public String value() {
        return value;
    }
        
    /**
     * Get string representation of this enum
     */
    @Override
    public String toString() {
        return value.toString();
    }

    /**
     * Convert list of StatusEnum values to list of string values
     * @param toConvert The list of StatusEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<StatusEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (StatusEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 