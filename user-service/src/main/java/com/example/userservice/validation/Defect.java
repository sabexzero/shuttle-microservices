package com.example.userservice.validation;

public record Defect(
        String path,
        DefectId defectId
) { }
