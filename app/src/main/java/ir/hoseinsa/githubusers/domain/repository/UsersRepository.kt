package ir.hoseinsa.githubusers.domain.repository

import ir.hoseinsa.githubusers.domain.models.user.UserPresenter
import ir.hoseinsa.githubusers.presenter.datastate.DataState
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun getUsers(): Flow<DataState<List<UserPresenter>>>

}
