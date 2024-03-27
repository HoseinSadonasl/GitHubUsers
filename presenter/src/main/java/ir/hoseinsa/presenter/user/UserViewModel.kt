package ir.hoseinsa.presenter.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.hoseinsa.domain.user.usecases.GetUser
import ir.hoseinsa.presenter.user.intent.UserDetailsScreenEvent
import ir.hoseinsa.presenter.user.state.UserState
import kotlinx.coroutines.launch

class UserViewModel(private val getUser: GetUser): ViewModel() {

    var state by mutableStateOf(UserState())
        private set

    fun onEvent(event: UserDetailsScreenEvent) = when (event) {
        is UserDetailsScreenEvent.GetUser -> getUser(event.username)
    }


    private fun getUser(username: String) {
        viewModelScope.launch {
            getUser.invoke(username).collect { result ->
                when {
                    result.isSuccess -> {
                        state = state.copy(
                            isLoading = false,
                            user = result.getOrNull()
                        )
                    }
                    result.isFailure -> {
                        state = state.copy(
                            isLoading = false,
                            error = result.exceptionOrNull()?.message
                        )
                    }
                }
            }
        }
    }

}