package ir.hoseinsa.presenter.user.state

import ir.hoseinsa.domain.user.model.User

data class UserState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String? = null
)
