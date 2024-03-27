package ir.hoseinsa.presenter.user.intent

sealed class UserDetailsScreenEvent() { data class GetUser(val username: String) : UserDetailsScreenEvent() }
