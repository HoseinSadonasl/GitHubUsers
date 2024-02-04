package ir.hoseinsa.githubusers.ui.datastate

import ir.hoseinsa.githubusers.domain.models.user.UserItem

sealed class DataState {
    data object Idle : DataState()
    data object Loading : DataState()
    data class Success<T>(val data: T?) : DataState()
    data class Error<T>(val error: T) : DataState()

}
