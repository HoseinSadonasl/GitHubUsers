package ir.hoseinsa.data.remote

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


private const val TIME_OUT = 10_000
private const val TAG_KTOR_LOGGER = "ktor_logger:"
private const val BASE_DOMAIN = "api.github.com"

fun githubClient() = HttpClient(Android) {
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = BASE_DOMAIN
        }
        contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
    }

    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        })
    }

    engine {
        connectTimeout = TIME_OUT
        socketTimeout = TIME_OUT
    }

    install(Logging) {
        logger = Logger.SIMPLE
        logger = object : Logger {
            override fun log(message: String) {
                Log.v(TAG_KTOR_LOGGER, message)
            }
        }
        level = LogLevel.ALL
    }
    headers { ContentType.Application.Json }
}