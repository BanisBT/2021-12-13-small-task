package com.example.routes

import com.example.model.User
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.userRouting() {
    get ("/api/users") {
        call.response.status(HttpStatusCode.OK)
        call.respond(mapOf("users" to users))
    }

    post ("api/users/create/parameters") {
        val id = checkNotNull(call.request.queryParameters["id"])
        val name = checkNotNull(call.request.queryParameters["name"])
        val surname = checkNotNull(call.request.queryParameters["surname"])
        val userCreate = User(id.toInt(), name, surname)

        users.add(userCreate)

        call.response.status(HttpStatusCode.OK)
        call.respond(mapOf("users" to users))
    }

    post ("api/users/create/body") {
        users += call.receive<User>()

        call.response.status(HttpStatusCode.OK)
        call.respond(mapOf("users" to users))
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
