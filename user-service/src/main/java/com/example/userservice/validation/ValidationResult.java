package com.example.userservice.validation;

import java.util.List;

public record ValidationResult(
    boolean isSuccess,
    List<Defect> errors
) { }