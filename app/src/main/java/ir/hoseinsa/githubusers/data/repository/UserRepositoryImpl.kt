package ir.hoseinsa.githubusers.data.repository

import io.ktor.client.call.body
import ir.hoseinsa.githubusers.data.api.UsersApi
import ir.hoseinsa.githubusers.domain.models.user.UserItem
import ir.hoseinsa.githubusers.domain.models.user.UserPresenter
import ir.hoseinsa.githubusers.domain.repository.UsersRepository
import ir.hoseinsa.githubusers.ui.datastate.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(val api: UsersApi) : UsersRepository {

    override suspend fun getUsers(): Flow<DataState> = flow {
        emit(DataState.Loading)
        try {
            val data = api.getUsers().body<List<UserItem>>()
            val presenterData = getUsersPresenter(data)
            emit(DataState.Success(presenterData))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(DataState.Error(e.message))
        }
    }

    private fun getUsersPresenter(users: List<UserItem>): List<UserPresenter> = users.map { user -> user.toUserPresenter() }

}