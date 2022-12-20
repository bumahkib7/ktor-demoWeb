package com.codeWarrior.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        var weather: String = "sunny"
        get("/weather_forecast") {
            call.respondText(weather, contentType = ContentType.Text.Plain)
        }

        post("/weather_forecast/post"){
            weather = call.receiveText()
            call.respondText("The weather has been set to $weather ",
                contentType = ContentType.Any, status = HttpStatusCode.Accepted)
        }
    }
}
