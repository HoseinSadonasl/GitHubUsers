package ir.hoseinsa.githubusers.data.di

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
import ir.hoseinsa.data.user.repository.UserRepositoryImpl
import ir.hoseinsa.domain.user.repository.UserRepository
import ir.hoseinsa.domain.users.repository.UsersRepository
import ir.hoseinsa.githubusers.data.remote.GithubApi
import ir.hoseinsa.githubusers.data.repository.UsersRepositoryImpl
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val dataModule = module {
    single<HttpClient> {
        HttpClient(Android) {
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
    }
    single<GithubApi> { GithubApi(get()) }
    single<UsersRepository> { UsersRepositoryImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
}

private const val TIME_OUT = 10_000
private const val TAG_KTOR_LOGGER = "ktor_logger:"
const val BASE_DOMAIN = "api.github.com"
