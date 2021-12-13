package com.example.routes

import com.example.DTO.UserParametersRequestDTO
import com.example.DTO.validationUserResponse
import com.example.model.User
import com.example.utils.validationHelper
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.userRouting() {
    route("api/users") {

        get {
            call.response.status(HttpStatusCode.OK)
            call.respond(mapOf("users" to users))
        }

        get("{id}") {
            val userId = checkNotNull(call.parameters["id"])
            val userRespond = users.find { it.id == userId.toInt() } ?: return@get call.respondText("User not found",
                status = HttpStatusCode.NotFound)
        }

        post("/create/parameters") {
            val id = checkNotNull(call.request.queryParameters["id"])
            val name = checkNotNull(call.request.queryParameters["name"])
            val surname = checkNotNull(call.request.queryParameters["surname"])

            validationHelper(validationUserResponse, UserParametersRequestDTO(id, name, surname))
            val userCreate = User(id.toInt(), name, surname)

            users.add(userCreate)

            call.response.status(HttpStatusCode.OK)
            call.respond(mapOf("users" to users))
        }

        post("/create/body") {
            users += call.receive<User>()

            call.response.status(HttpStatusCode.OK)
            call.respond(mapOf("users" to users))
        }

        delete("{id}/delete") {
            val userId = checkNotNull(call.parameters["id"])
            if (users.removeIf {it.id == userId.toInt()}) {
                call.respondText("User deleted with id $userId", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("User with id - $userId", status = HttpStatusCode.NotFound)
            }
        }
    }
}

fun Application.registerUserRouts() {
    routing {
        userRouting()
    }
}

var users = mutableListOf<User>(
    User(1, "Tomas", "Barauskas"),
    User(2, "Andrius", "Geras"),
    User(3, "Paulius", "Smith"),
    User(4, "Juozas", "Kalvis"),
)
