package ir.hoseinsa.githubusers.domain.repository

import io.ktor.client.statement.HttpResponse
import ir.hoseinsa.githubusers.domain.models.user.UserItem
import ir.hoseinsa.githubusers.domain.models.user.UserPresenter
import ir.hoseinsa.githubusers.ui.datastate.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface UsersRepository {

    suspend fun getUsers(): Flow<DataState<List<UserPresenter>>>

}
