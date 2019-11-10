package com.messagemedia.messages.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// TODO: Auto-generated Javadoc
/**
 * The Enum FormatEnum.
 */
public enum FormatEnum {
    
    /** The sms. */
    SMS, 
 /** The tts. */
 //TODO: Write general description for this element
    TTS, 
 /** The mms. */
 //TODO: Write general description for this element
    MMS; //TODO: Write general description for this element

    /** The value map. */
 private static TreeMap<String, FormatEnum> valueMap = new TreeMap<String, FormatEnum>();
    
    /** The value. */
    private String value;

    static {
        SMS.value = "SMS";
        TTS.value = "TTS";
        MMS.value = "MMS";

        valueMap.put("SMS", SMS);
        valueMap.put("TTS", TTS);
        valueMap.put("MMS", MMS);
    }

    /**
     * Returns the enum member associated with the given string value.
     *
     * @param toConvert the to convert
     * @return The enum member against the given string value
     */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static FormatEnum fromString(String toConvert) {
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
     * Convert list of FormatEnum values to list of string values.
     *
     * @param toConvert The list of FormatEnum values to convert
     * @return List of representative string values
     */
    public static List<String> toValue(List<FormatEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (FormatEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 