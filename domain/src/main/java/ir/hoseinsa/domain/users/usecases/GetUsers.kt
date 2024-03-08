package ir.hoseinsa.domain.users.usecases

import androidx.paging.PagingData
import ir.hoseinsa.domain.users.model.user.UserItem
import ir.hoseinsa.domain.users.repository.UsersRepository
import kotlinx.coroutines.flow.Flow

class GetUsers(private val usersRepository: UsersRepository) {

    operator fun invoke(): Flow<PagingData<UserItem>> = usersRepository.getUsers()

}
