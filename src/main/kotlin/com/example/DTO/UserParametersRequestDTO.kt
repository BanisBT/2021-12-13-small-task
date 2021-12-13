package com.example.DTO

import io.konform.validation.Validation
import io.konform.validation.jsonschema.pattern

data class UserParametersRequestDTO(
    val id: String,
    val name: String,
    val surname: String
)

val validationUserResponse = Validation<UserParametersRequestDTO> {
    UserParametersRequestDTO::id {
        pattern("[0-9]+") hint "Just numbers"
    }

    UserParametersRequestDTO::name {
        pattern("[\\w]+") hint "No symbols"
    }

    UserParametersRequestDTO::surname {
        pattern("[\\w]+") hint "No symbols"
    }
}
