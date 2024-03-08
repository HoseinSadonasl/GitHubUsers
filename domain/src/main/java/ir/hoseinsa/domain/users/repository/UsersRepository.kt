package ir.hoseinsa.domain.users.repository

import androidx.paging.PagingData
import ir.hoseinsa.domain.users.model.user.UserItem
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    fun getUsers(): Flow<PagingData<UserItem>>

}
