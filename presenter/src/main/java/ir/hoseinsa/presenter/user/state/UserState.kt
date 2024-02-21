package ir.hoseinsa.presenter.user.state

import ir.hoseinsa.domain.models.user.User

data class UserState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String? = null
)
