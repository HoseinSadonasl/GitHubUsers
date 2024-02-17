package ir.hoseinsa.domain.repository

import ir.hoseinsa.domain.models.user.UserPresenter
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun getUsers(): Flow<Result<List<UserPresenter>>>

}
