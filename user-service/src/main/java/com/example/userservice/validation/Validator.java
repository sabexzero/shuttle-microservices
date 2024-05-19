package com.example.userservice.validation;

import java.util.ArrayList;
import java.util.List;

public class Validator<T> {
    private final T fieldValue;
    private final String fieldName;
    private final List<Validator<?>> subResults = new ArrayList<>();
    private final List<DefectId> errors = new ArrayList<>();
    
    public Validator(T fieldValue) {
        this.fieldValue = fieldValue;
        this.fieldName = "";
    }
    
    public Validator(T fieldValue, String fieldName) {
        this.fieldValue = fieldValue;
        this.fieldName = fieldName;
    }
    
    public Validator<T> check(boolean checkResult, DefectId defectId) {
        if (!checkResult) {
            errors.add(defectId);
        }
        return this;
    }
    
    public <I> Validator<I> item(I fieldValue, String fieldName) {
        Validator<I> validator = new Validator<>(fieldValue, fieldName);
        subResults.add(validator);
        return validator;
    }
    
    private List<Defect> getAllErrors() {
        List<Defect> resultList = new ArrayList<>();
        for (DefectId defectId : errors) {
            resultList.add(new Defect(fieldName, defectId));
        }
        for (Validator<?> subValidator : subResults) {
            List<Defect> subErrors = subValidator.getAllErrors();
            for (Defect defect : subErrors) {
                if (!fieldName.isEmpty()) {
                    resultList.add(new Defect(fieldName + "." + defect.path(), defect.defectId()));
                } else {
                    resultList.add(defect);
                }
            }
        }
        return resultList;
    }
    
    public void validate() {
        List<Defect> errors = getAllErrors();
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
