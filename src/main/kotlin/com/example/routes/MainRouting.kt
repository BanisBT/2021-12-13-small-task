package com.example.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.mainRouting() {
    get("/") {
        call.respondText("Main page Hello")
    }
}

fun Application.registerMainRouting() {
    routing {
        mainRouting()
    }
}
