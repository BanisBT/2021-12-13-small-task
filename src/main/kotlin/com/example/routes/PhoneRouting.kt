package com.example.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.phoneRouting() {
    get ("/api/phones") {
        call.respondText("Phones")
    }
}

fun Application.registerPhoneRouting() {
    routing {
        phoneRouting()
    }
}
