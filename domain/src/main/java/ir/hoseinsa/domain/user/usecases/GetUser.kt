package ir.hoseinsa.domain.user.usecases

import ir.hoseinsa.domain.models.user.UserItem
import ir.hoseinsa.domain.user.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUser(private val userRepository: UserRepository) {

    operator fun invoke(username: String): Flow<Result<UserItem>> = userRepository.getUser(username)

}