package ir.hoseinsa.presenter.users.state

import androidx.paging.PagingData
import ir.hoseinsa.domain.users.model.user.UserItem
import kotlinx.coroutines.flow.Flow

data class UsersState(
    val isOnline: Boolean = true,
    val userItems: Flow<PagingData<UserItem>>? = null
)
