package ir.hoseinsa.githubusers.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class GithubApi(private val client: HttpClient) {

    suspend fun getUsers() = client.get("users")

    suspend fun getUser(user: String) = client.get("users/$user")

}