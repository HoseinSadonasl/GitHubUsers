package ir.hoseinsa.githubusers.data.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import ir.hoseinsa.githubusers.data.UsersEndpoints.USERS

class UsersApi(val client: HttpClient) {

    suspend fun getUsers() = client.get(USERS)

}