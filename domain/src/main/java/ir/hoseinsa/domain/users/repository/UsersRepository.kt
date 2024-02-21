package ir.hoseinsa.domain.users.repository

import ir.hoseinsa.domain.users.model.user.UserItem
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun getUsers(): Flow<Result<List<UserItem>>>

}
