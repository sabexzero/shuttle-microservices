package com.example.hibye.validation.defects

import com.example.userservice.validation.DefectId

enum class StringDefects : DefectId {
    INCORRECT_LENGTH,
    CONTAINS_FORBIDDEN_CHARACTERS
}