package ir.hoseinsa.presenter.user.state

import ir.hoseinsa.domain.users.model.user.UserItem

data class UserState(
    val isLoading: Boolean = false,
    val userItem: UserItem? = null,
    val error: String? = null
)
