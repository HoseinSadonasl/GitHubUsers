package ir.hoseinsa.presenter.users.state

import ir.hoseinsa.domain.users.model.user.UserItem

data class UsersState(
    val userItems: List<UserItem>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
