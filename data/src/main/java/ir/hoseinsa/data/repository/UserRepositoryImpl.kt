package ir.hoseinsa.githubusers.data.repository

import io.ktor.client.call.body
import ir.hoseinsa.githubusers.data.remote.UsersApi
import ir.hoseinsa.data.model.UserDto
import ir.hoseinsa.domain.models.user.User
import ir.hoseinsa.domain.users.repository.UsersRepository
import ir.hoseinsa.githubusers.data.mapper.getUsersPresenter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(private val api: UsersApi) : UsersRepository {

    override suspend fun getUsers(): Flow<Result<List<User>>> = flow {
        val data = api.getUsers()
            .body<List<UserDto>>()
        val presenterData = data.getUsersPresenter()
        return@flow try {
            emit(Result.success(presenterData))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }
}