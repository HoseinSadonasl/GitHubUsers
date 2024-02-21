package ir.hoseinsa.presenter.user.intent

sealed class UserDataIntent() { data class GetUser(val username: String) : UserDataIntent() }
