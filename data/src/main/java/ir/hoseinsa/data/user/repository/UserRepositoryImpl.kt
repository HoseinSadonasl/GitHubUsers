package ir.hoseinsa.data.user.repository

import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import ir.hoseinsa.data.user.mapper.toUser
import ir.hoseinsa.data.user.model.UserDto
import ir.hoseinsa.domain.user.model.User
import ir.hoseinsa.domain.user.repository.UserRepository
import ir.hoseinsa.githubusers.data.remote.GithubApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(private val api: GithubApi) : UserRepository {

    override fun getUser(username: String): Flow<Result<User>> = flow {
        val response = api.getUser(username)
        try {
            when(response.status) {
                HttpStatusCode.OK -> {
                    val data = response.body<UserDto>()
                    val user = data.toUser()
                    emit(Result.success(user))
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }
}
