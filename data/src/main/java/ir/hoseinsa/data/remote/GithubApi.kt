package ir.hoseinsa.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class GithubApi(private val client: HttpClient) {

    suspend fun getUsers(since: Int, perPage: Int) =
        client.get("users??since=$since&per_page=$perPage")

    suspend fun getUser(user: String) = client.get("users/$user")

}