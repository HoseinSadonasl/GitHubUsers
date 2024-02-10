package ir.hoseinsa.githubusers.data.di

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import ir.hoseinsa.githubusers.data.remote.UsersApi
import org.koin.dsl.module

val dataModule = module {
    single<HttpClient> {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json()
            }

            engine {
                connectTimeout = TIME_OUT
                socketTimeout = TIME_OUT
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.v(TAG_KTOR_LOGGER, message)
                    }
                }
                level = LogLevel.ALL
            }

            headers { ContentType.Application.Json }
        }
    }
    single<UsersApi> { UsersApi(get()) }
}

private const val TIME_OUT = 10_000
private const val TAG_KTOR_LOGGER = "ktor_logger:"
