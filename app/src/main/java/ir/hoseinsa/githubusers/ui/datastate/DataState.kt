package ir.hoseinsa.githubusers.ui.datastate

import ir.hoseinsa.githubusers.data.models.UsersItem

sealed class DataState {
    data object Loading : DataState()
    data class Success(val users: List<UsersItem>) : DataState()
    data class Error(val error: Exception) : DataState()

}
