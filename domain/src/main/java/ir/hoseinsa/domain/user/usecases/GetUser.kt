package ir.hoseinsa.domain.user.usecases

import ir.hoseinsa.domain.models.user.User
import ir.hoseinsa.domain.user.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUser(private val userRepository: UserRepository) {

    operator fun invoke(username: String): Flow<Result<User>> = userRepository.getUser(username)

}