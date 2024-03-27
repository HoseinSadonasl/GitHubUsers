package ir.hoseinsa.presenter.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import ir.hoseinsa.domain.users.usecases.GetUsers
import ir.hoseinsa.presenter.users.intent.UsersScreenEvent
import ir.hoseinsa.presenter.users.state.UsersState
import ir.hoseinsa.presenter.utils.ConnectionUtils.isOnline
import kotlinx.coroutines.launch

class UsersViewModel(private val getUsers: GetUsers) : ViewModel() {

    var state by mutableStateOf(UsersState())
        private set

    fun onEvent(event: UsersScreenEvent) = when (event) {
        is UsersScreenEvent.GetUsers -> getUsers()
    }

    private fun getUsers() {
        if (isOnline()) {
            viewModelScope.launch {
                val items = getUsers.invoke().cachedIn(viewModelScope)
                state = state.copy(
                    userItems = items
                )
            }
        } else state = state.copy(
            isOnline = false
        )
    }

}