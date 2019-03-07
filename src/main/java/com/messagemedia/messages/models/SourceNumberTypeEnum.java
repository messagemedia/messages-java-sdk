package com.messagemedia.messages.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum SourceNumberTypeEnum {
    INTERNATIONAL, //TODO: Write general description for this element
    ALPHANUMERIC, //TODO: Write general description for this element
    SHORTCODE; //TODO: Write general description for this element

    private static TreeMap<String, SourceNumberTypeEnum> valueMap = new TreeMap<String, SourceNumberTypeEnum>();
    private String value;

    static {
        INTERNATIONAL.value = "INTERNATIONAL";
        ALPHANUMERIC.value = "ALPHANUMERIC";
        SHORTCODE.value = "SHORTCODE";

        valueMap.put("INTERNATIONAL", INTERNATIONAL);
        valueMap.put("ALPHANUMERIC", ALPHANUMERIC);
        valueMap.put("SHORTCODE", SHORTCODE);
    }

  
    @com.fasterxml.jackson.annotation.JsonCreator
    public static SourceNumberTypeEnum fromString(String toConvert) {
        return valueMap.get(toConvert);
    }

  
    @com.fasterxml.jackson.annotation.JsonValue
    public String value() {
        return value;
    }
        

    @Override
    public String toString() {
        return value.toString();
    }


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