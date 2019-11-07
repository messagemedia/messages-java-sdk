package com.messagemedia.messages.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum Status2Enum {
    ENROUTE, //TODO: Write general description for this element
    FAILED, //TODO: Write general description for this element
    SUBMITTED, //TODO: Write general description for this element
    DELIVERED, //TODO: Write general description for this element
    EXPIRED, //TODO: Write general description for this element
    REJECTED, //TODO: Write general description for this element
    UNDELIVERABLE; //TODO: Write general description for this element

    private static TreeMap<String, Status2Enum> valueMap = new TreeMap<String, Status2Enum>();
    private String value;

    static {
        ENROUTE.value = "enroute";
        FAILED.value = "failed";
        SUBMITTED.value = "submitted";
        DELIVERED.value = "delivered";
        EXPIRED.value = "expired";
        REJECTED.value = "rejected";
        UNDELIVERABLE.value = "undeliverable";

        valueMap.put("enroute", ENROUTE);
        valueMap.put("failed", FAILED);
        valueMap.put("submitted", SUBMITTED);
        valueMap.put("delivered", DELIVERED);
        valueMap.put("expired", EXPIRED);
        valueMap.put("rejected", REJECTED);
        valueMap.put("undeliverable", UNDELIVERABLE);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static Status2Enum fromString(String toConvert) {
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
     * Convert list of Status2Enum values to list of string values
     * @param toConvert The list of Status2Enum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<Status2Enum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (Status2Enum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 