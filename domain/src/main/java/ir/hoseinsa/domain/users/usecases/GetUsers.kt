package ir.hoseinsa.domain.users.usecases

import ir.hoseinsa.domain.models.user.User
import ir.hoseinsa.domain.users.repository.UsersRepository
import kotlinx.coroutines.flow.Flow

class GetUsers(private val users: UsersRepository) {

    suspend operator fun invoke(): Flow<Result<List<User>>> = users.getUsers()




}
