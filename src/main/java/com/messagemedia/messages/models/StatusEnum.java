package com.messagemedia.messages.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// TODO: Auto-generated Javadoc
/**
 * The Enum StatusEnum.
 */
public enum StatusEnum {
    
    /** The enroute. */
    ENROUTE, 
 /** The submitted. */
 //TODO: Write general description for this element
    SUBMITTED, 
 /** The delivered. */
 //TODO: Write general description for this element
    DELIVERED, 
 /** The expired. */
 //TODO: Write general description for this element
    EXPIRED, 
 /** The rejected. */
 //TODO: Write general description for this element
    REJECTED, 
 /** The undeliverable. */
 //TODO: Write general description for this element
    UNDELIVERABLE, 
 /** The queued. */
 //TODO: Write general description for this element
    QUEUED, 
 /** The processed. */
 //TODO: Write general description for this element
    PROCESSED, 
 /** The cancelled. */
 //TODO: Write general description for this element
    CANCELLED, 
 /** The scheduled. */
 //TODO: Write general description for this element
    SCHEDULED, 
 /** The failed. */
 //TODO: Write general description for this element
    FAILED; //TODO: Write general description for this element

    /** The value map. */
 private static TreeMap<String, StatusEnum> valueMap = new TreeMap<String, StatusEnum>();
    
    /** The value. */
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
     * Returns the enum member associated with the given string value.
     *
     * @param toConvert the to convert
     * @return The enum member against the given string value
     */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static StatusEnum fromString(String toConvert) {
        return valueMap.get(toConvert);
    }

    /**
     * Returns the string value associated with the enum member.
     *
     * @return The string value against enum member
     */
    @com.fasterxml.jackson.annotation.JsonValue
    public String value() {
        return value;
    }
        
    /**
     * Get string representation of this enum.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return value.toString();
    }

    /**
     * Convert list of StatusEnum values to list of string values.
     *
     * @param toConvert The list of StatusEnum values to convert
     * @return List of representative string values
     */
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