package ir.hoseinsa.domain.user.repository

import ir.hoseinsa.domain.user.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUser(username: String): Flow<Result<User>>

}