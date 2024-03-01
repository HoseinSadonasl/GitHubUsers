package ir.hoseinsa.data.users.repository

import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import ir.hoseinsa.data.users.model.UsersItemDto
import ir.hoseinsa.domain.users.model.user.UserItem
import ir.hoseinsa.domain.users.repository.UsersRepository
import ir.hoseinsa.data.users.mapper.toUsersItem
import ir.hoseinsa.data.remote.GithubApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UsersRepositoryImpl(private val api: GithubApi) : UsersRepository {

    override fun getUsers(): Flow<Result<List<UserItem>>> = flow {
        val response = api.getUsers()
        try {
            when(response.status) {
                HttpStatusCode.OK -> {
                    val data = response.body<List<UsersItemDto>>()
                    val usersData = data.toUsersItem()
                    emit(Result.success(usersData))
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }
}