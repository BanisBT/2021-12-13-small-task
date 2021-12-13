package com.example.utils

import com.example.exceptions.ValidationException
import io.konform.validation.Invalid
import io.konform.validation.Validation

fun <T>validationHelper(validation: Validation<T>, validatedEntity: T) {
    val validationResult = validation.validate(validatedEntity)
    if (validationResult is Invalid<*>) {
        throw ValidationException(validationResult.errors.toString(), validationResult.errors)
    }
}
