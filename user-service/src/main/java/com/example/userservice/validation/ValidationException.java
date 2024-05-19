package com.example.userservice.validation;

import com.example.userservice.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ValidationException extends RuntimeException {
    public ValidationException(List<Defect> errors) {
        super(convertErrorsToJson(errors));
    }
    
    private static String convertErrorsToJson(List<Defect> errors) {
        try {
            return JsonUtils.objectToJson(errors);
        } catch (JsonProcessingException exception) {
            log.error("The list of validation errors could not be converted", exception);
            return "The list of validation errors could not be converted";
        }
    }
    
}