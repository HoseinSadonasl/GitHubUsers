package ir.hoseinsa.githubusers.ui.datastate

import ir.hoseinsa.githubusers.data.models.UsersItem

sealed class DataState {
    data object loading : DataState()
    data class success(val users: List<UsersItem>) : DataState()
    data class error(val error: Exception) : DataState()

}
