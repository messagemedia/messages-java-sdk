package com.messagemedia.messages.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// TODO: Auto-generated Javadoc
/**
 * The Enum SourceNumberTypeEnum.
 */
public enum SourceNumberTypeEnum {
    
    /** The international. */
    INTERNATIONAL, 
 /** The alphanumeric. */
 //TODO: Write general description for this element
    ALPHANUMERIC, 
 /** The shortcode. */
 //TODO: Write general description for this element
    SHORTCODE; //TODO: Write general description for this element

    /** The value map. */
 private static TreeMap<String, SourceNumberTypeEnum> valueMap = new TreeMap<String, SourceNumberTypeEnum>();
    
    /** The value. */
    private String value;

    static {
        INTERNATIONAL.value = "INTERNATIONAL";
        ALPHANUMERIC.value = "ALPHANUMERIC";
        SHORTCODE.value = "SHORTCODE";

        valueMap.put("INTERNATIONAL", INTERNATIONAL);
        valueMap.put("ALPHANUMERIC", ALPHANUMERIC);
        valueMap.put("SHORTCODE", SHORTCODE);
    }

    /**
     * Returns the enum member associated with the given string value.
     *
     * @param toConvert the to convert
     * @return The enum member against the given string value
     */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static SourceNumberTypeEnum fromString(String toConvert) {
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
     * Convert list of SourceNumberTypeEnum values to list of string values.
     *
     * @param toConvert The list of SourceNumberTypeEnum values to convert
     * @return List of representative string values
     */
    public static List<String> toValue(List<SourceNumberTypeEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (SourceNumberTypeEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 