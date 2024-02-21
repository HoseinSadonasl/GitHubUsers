package ir.hoseinsa.githubusers.data.repository

import io.ktor.client.call.body
import ir.hoseinsa.data.users.model.UsersItemDto
import ir.hoseinsa.domain.users.model.user.UserItem
import ir.hoseinsa.domain.users.repository.UsersRepository
import ir.hoseinsa.githubusers.data.mapper.toUsersItem
import ir.hoseinsa.githubusers.data.remote.GithubApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UsersRepositoryImpl(private val api: GithubApi) : UsersRepository {

    override suspend fun getUsers(): Flow<Result<List<UserItem>>> = flow {
        val data = api.getUsers().body<List<UsersItemDto>>()
        val usersData = data.toUsersItem()
        try {
            emit(Result.success(usersData))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }
}