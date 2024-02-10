package ir.hoseinsa.githubusers.presenter.users

import ir.hoseinsa.githubusers.domain.models.user.UserPresenter

data class UsersState(
    val users: List<UserPresenter>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
