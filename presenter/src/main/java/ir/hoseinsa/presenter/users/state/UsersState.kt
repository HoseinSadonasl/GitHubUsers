package ir.hoseinsa.presenter.users.state

import ir.hoseinsa.domain.models.user.User

data class UsersState(
    val users: List<User>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
