package ir.hoseinsa.presenter.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.hoseinsa.domain.user.usecases.GetUser
import ir.hoseinsa.presenter.user.intent.UserDataIntent
import ir.hoseinsa.presenter.user.state.UserState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class UserViewModel(private val getUser: GetUser): ViewModel() {

    val dataIntent = Channel<UserDataIntent>(Channel.UNLIMITED)
    var userState by mutableStateOf(UserState())
        private set

    init {
        handleIntent()
    }

    private fun handleIntent() = dataIntent.consumeAsFlow().onEach { dataIntent ->
        when (dataIntent) {
            is UserDataIntent.GetUser -> getUser(dataIntent.username)
        }
    }.launchIn(viewModelScope)


    private fun getUser(username: String) {
        userState = userState.copy(
            isLoading = true
        )
        viewModelScope.launch {
            getUser.invoke(username).collect { result ->
                when {
                    result.isSuccess -> {
                        userState = userState.copy(
                            isLoading = false,
                            userItem = result.getOrNull()
                        )
                    }
                    result.isFailure -> {
                        userState = userState.copy(
                            isLoading = false,
                            error = result.exceptionOrNull()?.message
                        )
                    }
                }
            }
        }
    }

}