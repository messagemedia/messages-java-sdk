package com.messagemedia.messages;

import java.io.File;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;

import com.messagemedia.messages.exceptions.APIException;

public class APIHelper {
    /* used for async execution of API calls using a thread pool */
    private static ExecutorService scheduler = null;
    private static final Object syncRoot = new Object();
  
  
    public static ExecutorService getScheduler() {
        if (null == scheduler) {
            synchronized(syncRoot) {
                if (null == scheduler) {
                    scheduler = Executors.newCachedThreadPool();
                }
            }
        }
        return scheduler;
    }

 
    public static void shutdown() {
        if(null != scheduler) {
            scheduler.shutdown();
        }
    }

    /* used for deserialization of json data */
    public static ObjectMapper mapper = new ObjectMapper()
    {
        private static final long serialVersionUID = -174113593500315394L;
        {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }
    };

 
    private static JsonSerializer getSerializer(Annotation serializerAnnotation)
    {
        String sa = serializerAnnotation.toString();
        sa = sa.substring(sa.indexOf("using=class ") + 12);
        sa = sa.substring(0, sa.indexOf(','));
        try {
            return (JsonSerializer) Class.forName(sa).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String serialize(Object obj)
            throws JsonProcessingException {
        if(null == obj)
            return null;

        return mapper.writeValueAsString(obj);
    }


    public static String serialize(Object obj, final JsonSerializer serializer)
            throws JsonProcessingException {
        if(null == obj || null == serializer)
            return null;
        
        if (obj.getClass().getName().equals("java.util.ArrayList"))     // need to find the generic type if it's an ArrayList
        {
            final Class<? extends Object> cls = ((ArrayList) obj).get(0).getClass();

            return new ObjectMapper() {
                private static final long serialVersionUID = -1639089569991988232L;
                {
                    SimpleModule module = new SimpleModule();
                    module.addSerializer(cls, serializer);
                    this.registerModule(module);
                }
            }.writeValueAsString(obj);
        }
        else {
            final Class<? extends Object> cls = obj.getClass();

            return new ObjectMapper() {
                private static final long serialVersionUID = -1639089569991988232L;
                {
                    SimpleModule module = new SimpleModule();
                    module.addSerializer(cls, serializer);
                    this.registerModule(module);
                }
            }.writeValueAsString(obj);
        }
    }


    public static <T extends Object> T deserialize(String json, TypeReference<T> typeReference)
            throws IOException {
        if (isNullOrWhiteSpace(json))
            return null;

        return mapper.readValue(json, typeReference);
    }


    public static <T extends Object> List<T> deserialize(String json, final TypeReference<List<T>> typeReference,
            final Class<T> cls, final JsonDeserializer<T> deserializer) throws IOException {
        if (isNullOrWhiteSpace(json))
            return null;
        
        return new ObjectMapper() {
            private static final long serialVersionUID = -1639089569991988232L;

            {
                SimpleModule module = new SimpleModule();
                module.addDeserializer(cls, deserializer);
                this.registerModule(module);
            }
        }.readValue(json, typeReference);
    }


    public static <T extends Object> T deserialize(String json, Class<T> typeReference)
            throws IOException {
        if (isNullOrWhiteSpace(json))
            return null;

        return mapper.readValue(json, typeReference);
    }

 
    public static void populate(String json, APIException obj)
            throws IOException {
        if (!isNullOrWhiteSpace(json))
            mapper.readerForUpdating(obj).readValue(json);;
    }

 
    public static LinkedHashMap<String, Object> deserialize(String json)
            throws IOException {
        if (isNullOrWhiteSpace(json))
            return null;

        TypeReference<LinkedHashMap<String,Object>> typeRef 
            = new TypeReference<LinkedHashMap<String,Object>>() {};
        return deserialize(json, typeRef);
    }

  
    public static void appendUrlWithTemplateParameters(StringBuilder queryBuilder, Map<String, Object> parameters) {
        //perform parameter validation
        if (null == queryBuilder)
            throw new IllegalArgumentException("Given value for parameter \"queryBuilder\" is invalid." );

        if (null == parameters)
            return;

        //iterate and append parameters
        for (Map.Entry<String, Object> pair : parameters.entrySet()) {
             String replaceValue = "";

             //load element value as string
             if (null == pair.getValue())
                 replaceValue = "";
             else if (pair.getValue() instanceof Collection<?>)
                 replaceValue = flattenCollection("", (Collection<?>) pair.getValue(), "%s%s%s", '/');
             else
                 replaceValue = tryUrlEncode(pair.getValue().toString());

             //find the template parameter and replace it with its value
             replaceAll(queryBuilder, "{" + pair.getKey() + "}", replaceValue);
        }
    }


    public static void appendUrlWithQueryParameters(StringBuilder queryBuilder, Map<String, Object> parameters) {
        //perform parameter validation
        if (null == queryBuilder)
            throw new IllegalArgumentException("Given value for parameter \"queryBuilder\" is invalid.");

        if (null == parameters)
            return;

        //does the query string already has parameters
        boolean hasParams = queryBuilder.indexOf("?") > 0;
        queryBuilder.append(hasParams ? '&' : '?');

        encodeObjectAsQueryString("", parameters, queryBuilder);
    }

 
    public static boolean isNullOrWhiteSpace(String s) {
        if(s == null)
            return true;

        int length = s.length();
        if (length > 0) {
            for (int start = 0, middle = length / 2, end = length - 1; start <= middle; start++, end--) {
                if (s.charAt(start) > ' ' || s.charAt(end) > ' ') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    public static void replaceAll(StringBuilder stringBuilder, String toReplace, String replaceWith) {
        int index = stringBuilder.indexOf(toReplace);
        
        while (index != -1) {
            stringBuilder.replace(index, index + toReplace.length(), replaceWith);
            index += replaceWith.length(); // Move to the end of the replacement
            index = stringBuilder.indexOf(toReplace, index);
        }
    }


    public static void removeNullValues(Map<String, ?> map) {
        if(map == null)
            return;
        map.values().removeAll(Collections.singleton(null));
    }


    public static String cleanUrl(StringBuilder url)
    {
        //ensure that the urls are absolute
        Pattern pattern = Pattern.compile("^(https?://[^/]+)");
        Matcher matcher = pattern.matcher(url);
        if (!matcher.find())
            throw new IllegalArgumentException("Invalid Url format.");

        //get the http protocol match
        String protocol = matcher.group(1);

        //remove redundant forward slashes
        String query = url.substring(protocol.length());
        query = query.replaceAll("//+", "/");

        //return process url
        return protocol.concat(query);
    }

 
    public static List<SimpleEntry<String, Object>> prepareFormFields(Object value) {
        List<SimpleEntry<String, Object>> formFields = new ArrayList<SimpleEntry<String, Object>>();
        if(value != null) {
            try {
                objectToList("", value, formFields, new HashSet<Integer>());
            } catch (Exception ex) {
            }
        }
        return formFields;
    }


    private static void encodeObjectAsQueryString(String name, Object obj, StringBuilder objBuilder) {
        try {
            if(obj == null)
                return;

            List<SimpleEntry<String, Object>> objectList = new ArrayList<SimpleEntry<String, Object>>();
            objectToList(name, obj, objectList, new HashSet<Integer>());
            boolean hasParam = false;

            List<String> arrays = new ArrayList<String>();
                        
            for (SimpleEntry<String, Object> pair : objectList) {
                String paramKeyValPair;
                String accessor = pair.getKey();
                //ignore nulls
                Object value = pair.getValue();
                if(value == null)
                    continue;

                hasParam = true;
                //load element value as string
                paramKeyValPair = String.format("%s=%s&", accessor, tryUrlEncode(value.toString()));
                objBuilder.append(paramKeyValPair);

            }

            //remove the last &
            if(hasParam) {
                objBuilder.setLength(objBuilder.length() - 1);
            }
        } catch (Exception ex) {
        }
    }


    private static String flattenCollection(String elemName, Collection<?> array, String fmt, char separator) {
        StringBuilder builder = new StringBuilder();

        //append all elements in the array into a string
        for (Object element : array) {
            String elemValue = null;

            //replace null values with empty string to maintain index order
            if (null == element) {
                elemValue = "";
            } else {
                elemValue = element.toString();
            }
            elemValue = tryUrlEncode(elemValue);
            builder.append(String.format(fmt, elemName, elemValue, separator));
        }

        //remove the last separator, if appended
        if ((builder.length() > 1) && (builder.charAt(builder.length() - 1) == separator))
            builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }


    private static String tryUrlEncode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        }catch (Exception ex) {
            return value;
        }
    }


    private static void objectToList(
            String objName, Object obj, List<SimpleEntry<String,Object>> objectList, HashSet<Integer> processed)
    throws InvalidObjectException {
        //null values need not to be processed
        if(obj == null)
            return;

        //wrapper types are autoboxed, so reference checking is not needed
        if(!isWrapperType(obj.getClass())) {
            //avoid infinite recursion
            if(processed.contains(objName.hashCode()))
                return;
            processed.add(objName.hashCode());
        }

        //process arrays
        if(obj instanceof Collection<?>) {
            //process array
            if((objName == null) ||(objName.isEmpty()))
                throw new InvalidObjectException("Object name cannot be empty");
            
            Collection<?> array = (Collection<?>) obj;
            //append all elements in the array into a string
            int index = 0;
            for (Object element : array) {
                //load key value pair
                String key = String.format("%s[%d]", objName, index++);
                loadKeyValuePairForEncoding(key, element, objectList, processed);
            }
        } else if(obj.getClass().isArray()) {
            //process array
            if((objName == null) ||(objName.isEmpty()))
                throw new InvalidObjectException("Object name cannot be empty");

            Object[] array = (Object[]) obj;
            //append all elements in the array into a string
            int index = 0;
            for (Object element : array) {
                //load key value pair
                String key = String.format("%s[%d]", objName, index++);
                loadKeyValuePairForEncoding(key, element, objectList, processed);
            }
         } else if(obj instanceof Map) {
             //process map
            Map<?, ?> map = (Map<?, ?>) obj;
            //append all elements in the array into a string
            for (Map.Entry<?, ?> pair : map.entrySet()) {
                String attribName = pair.getKey().toString();
                String key = attribName;
                if((objName != null) && (!objName.isEmpty())) {
                    key = String.format("%s[%s]", objName, attribName);
                }
                loadKeyValuePairForEncoding(key, pair.getValue(), objectList, processed);
            }
        } else if(obj instanceof UUID) {
            String key = objName;
            String value = obj.toString();
            //UUIDs can be converted to string
            loadKeyValuePairForEncoding(key, value, objectList, processed);
        } else {
            //process objects
            // invoke getter methods
            Method[] methods = obj.getClass().getMethods();
            for (Method method : methods) {
                //is a getter?
                if ((method.getParameterTypes().length != 0)
                        || (!method.getName().startsWith("get")))
                    continue;

                //get json attribute name
                Annotation getterAnnotation = method.getAnnotation(JsonGetter.class);
                if (getterAnnotation == null)
                    continue;

                //load key name
                String attribName = ((JsonGetter) getterAnnotation).value();
                String key = attribName;
                if ((objName != null) && (!objName.isEmpty())) {
                    key = String.format("%s[%s]", objName, attribName);
                }

                try {
                    //load key value pair
                    Object value = method.invoke(obj);
                    Annotation serializerAnnotation = method.getAnnotation(JsonSerialize.class);
                    if (serializerAnnotation != null)
                        loadKeyValuePairForEncoding(key, value, objectList, processed, serializerAnnotation);
                    else
                        loadKeyValuePairForEncoding(key, value, objectList, processed);
                } catch (Exception ex) {
                }
            }
            // load fields
            Field[] fields = obj.getClass().getFields();
            for (Field field : fields) {
                //load key name
                String attribName = field.getName();
                String key = attribName;
                if ((objName != null) && (!objName.isEmpty())) {
                    key = String.format("%s[%s]", objName, attribName);
                }

                try {
                    //load key value pair
                    Object value = field.get(obj);
                    loadKeyValuePairForEncoding(key, value, objectList, processed);
                } catch (Exception ex) { }
            }
        }
    }


    private static void loadKeyValuePairForEncoding(
            String key, Object value, List<SimpleEntry<String, Object>> objectList, HashSet<Integer> processed)
    throws InvalidObjectException {
        if(value == null)
            return;
        if (isWrapperType(value.getClass()))
            objectList.add( new SimpleEntry<String, Object>(key, value));
        else
            objectToList(key, value, objectList, processed);
    }

 
    private static void loadKeyValuePairForEncoding(
            String key, Object value, List<SimpleEntry<String, Object>> objectList, HashSet<Integer> processed,
            Annotation serializerAnnotation)
    throws InvalidObjectException {
        if(value == null)
            return;
        try {
            value = serialize(value, getSerializer(serializerAnnotation));
            if (value.toString().startsWith("\""))
                value = value.toString().substring(1, value.toString().length()-1);
            objectList.add( new SimpleEntry<String, Object>(key, value));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static final Set<Class> WRAPPER_TYPES = new HashSet(Arrays.asList(
            Boolean.class, Character.class, Byte.class, Short.class, String.class,
            Integer.class, Long.class, Float.class, Double.class, Void.class, File.class));


    private static boolean isWrapperType(Class clazz) {
        return WRAPPER_TYPES.contains(clazz) || clazz.isPrimitive() || clazz.isEnum();
    }
}