package com.example.plugins

import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.application.*
import io.ktor.mustache.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureTemplating() {
    install(Mustache) {
        mustacheFactory = DefaultMustacheFactory("templates/mustache")
    }

    routing {
        get("/html-mustache") {
            call.respond(
                MustacheContent(
                    "index.hbs", mapOf(
                        "user" to MustacheUser(1, "user1"),
                        "listas" to list,
                        "mapArray" to mapArray
                    )
                )
            )
        }
    }
}

data class MustacheUser(val id: Int, val name: String)

val list = listOf<String>("Java", "Kotlin", "JS")

val mapArray = mapOf(
    "tittle" to listOf<String>("1", "2", "3")
)
