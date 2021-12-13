package com.example.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.userRouting() {
    get ("/users") {
        call.respondText("users")
    }
}

fun Application.registerUserRouts() {
    routing {
        userRouting()
    }
}
