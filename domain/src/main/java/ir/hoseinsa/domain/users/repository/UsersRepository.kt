package ir.hoseinsa.domain.users.repository

import ir.hoseinsa.domain.models.user.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun getUsers(): Flow<Result<List<User>>>

}
