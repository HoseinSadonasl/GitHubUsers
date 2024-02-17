package ir.hoseinsa.domain.usecases

import ir.hoseinsa.domain.models.user.UserPresenter
import ir.hoseinsa.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow

class GetUsers(private val users: UsersRepository) {

    suspend operator fun invoke(): Flow<Result<List<UserPresenter>>> = users.getUsers()




}
