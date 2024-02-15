package ir.hoseinsa.githubusers.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class UsersApi(val client: HttpClient) {

    suspend fun getUsers() = client.get("users")

}