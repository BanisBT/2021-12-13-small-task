package com.example.plugins

import com.example.routes.registerMainRouting
import com.example.routes.registerPhoneRouting
import com.example.routes.registerUserRouts
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    routing {
        static("/static") {
            resources("static")
        }
    }
    registerMainRouting()
    registerUserRouts()
    registerPhoneRouting()
}
