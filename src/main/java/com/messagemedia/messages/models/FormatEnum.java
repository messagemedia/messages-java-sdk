package com.messagemedia.messages.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum FormatEnum {
    SMS, //TODO: Write general description for this element
    TTS, //TODO: Write general description for this element
    MMS; //TODO: Write general description for this element

    private static TreeMap<String, FormatEnum> valueMap = new TreeMap<String, FormatEnum>();
    private String value;

    static {
        SMS.value = "SMS";
        TTS.value = "TTS";
        MMS.value = "MMS";

        valueMap.put("SMS", SMS);
        valueMap.put("TTS", TTS);
        valueMap.put("MMS", MMS);
    }


    @com.fasterxml.jackson.annotation.JsonCreator
    public static FormatEnum fromString(String toConvert) {
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