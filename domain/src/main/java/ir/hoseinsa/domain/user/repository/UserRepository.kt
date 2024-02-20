package ir.hoseinsa.domain.user.repository

import ir.hoseinsa.domain.models.user.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUser(username: String): Flow<Result<User>>

}