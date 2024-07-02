package org.example.feedbackservice.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    // Generic method to read JSON into a specific class
    public static <T extends Serializable> T readJson(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }

    // Generic method to write an object as JSON
    public static <T extends Serializable> String writeJson(T t) throws JsonProcessingException {
        return mapper.writeValueAsString(t);
    }

    // Generic method to read JSON into a specific TypeReference
    public static <T extends Serializable> T readJson(String json, TypeReference<T> typeReference) throws IOException {
        return mapper.readValue(json, typeReference);
    }
}
