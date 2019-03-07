package com.messagemedia.messages.models;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;

import com.messagemedia.messages.APIHelper;
import com.messagemedia.messages.http.response.HttpResponse;
import com.messagemedia.messages.http.response.HttpStringResponse;

/**
 * Represents dynamic response returned by an API call.
 * 
 * Allows user to lazily parse the response as a primtive
 * or a more complex type using parse(). 
 */
public class DynamicResponse {
    private HttpResponse response;
    private String responseString;


    public DynamicResponse(HttpResponse responseBody) {
        this.response = responseBody;
    }
    

    public <T> T parse(Class<T> cls) throws ParseException {
        try {
            return APIHelper.deserialize(getResponseString(), cls);
        } catch (Exception e) {
            throw new java.text.ParseException("Could not deserialize dynamic content as given type", 0);
        }
    }


    public boolean parseAsBoolean() throws ParseException {
        return this.parse(Boolean.class);
    }


    public byte parseAsByte() throws ParseException {
        return this.parse(Byte.class);
    }


    public char parseAsCharacter() throws ParseException {
        return this.parse(Character.class);
    }


    public float parseAsFloat() throws ParseException {
        return this.parse(Float.class);
    }


    public int parseAsInteger() throws ParseException {
        return this.parse(Integer.class);
    }

 
    public long parseAsLong() throws ParseException {
        return this.parse(Long.class);
    }

 
    public short parseAsShort() throws ParseException {
        return this.parse(Short.class);
    }

  
    public double parseAsDouble() throws ParseException {
        return this.parse(Double.class);
    }
    
  
    public String parseAsString() throws ParseException {
        try {
            return getResponseString();			
        } catch (Throwable e) {
            throw new java.text.ParseException("Could not deserialize dynamic content as given type", 0);
        }
    }

  
    public Map<String, Object> parseAsDictionary() throws ParseException {
        try {
            return APIHelper.deserialize(getResponseString());
        } catch (IOException e) {
            throw new java.text.ParseException("Could not deserialize dynamic content as given type", 0);
        }
    }
    
 
    public InputStream getRawBody() {
        return response.getRawBody();
    }
    

    public Map<String, String> getHeaders() {
        return response.getHeaders();
    }

  
    private String getResponseString() {
        if(responseString == null) {
            responseString = ((HttpStringResponse)response).getBody();
        }
        return responseString;
    }
}
