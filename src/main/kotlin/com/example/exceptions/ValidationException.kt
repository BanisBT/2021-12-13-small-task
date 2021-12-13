package com.example.exceptions

import io.konform.validation.ValidationErrors
import java.lang.IllegalArgumentException

data class ValidationException(
    val validationMessage: String,
    val validationErrors: ValidationErrors
) : IllegalArgumentException()
