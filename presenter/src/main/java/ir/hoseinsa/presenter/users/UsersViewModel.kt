package ir.hoseinsa.presenter.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.hoseinsa.domain.users.usecases.GetUsers
import ir.hoseinsa.presenter.users.intent.UsersDataIntent
import ir.hoseinsa.presenter.users.state.UsersState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class UsersViewModel(private val getUsers: GetUsers) : ViewModel() {

    val dataIntent = Channel<UsersDataIntent>(Channel.UNLIMITED)
    var usersState by mutableStateOf(UsersState())
        private set

    init {
        handleIntent()
    }

    private fun handleIntent() = dataIntent.consumeAsFlow().onEach { dataIntent ->
        when (dataIntent) {
            is UsersDataIntent.GetUsers -> getUsers()
        }
    }.launchIn(viewModelScope)


    fun sendIntent() = viewModelScope.launch {
        dataIntent.send(UsersDataIntent.GetUsers)
    }


    private fun getUsers() {
        viewModelScope.launch {
            usersState = usersState.copy(
                users = null,
                isLoading = true,
                error = null
            )
            getUsers.invoke().collect { result ->
                when {
                    result.isSuccess  -> {
                        usersState = usersState.copy(
                            users = result.getOrNull() ,
                            isLoading = false,
                            error = null
                        )
                    }

                    result.isFailure -> {
                        usersState = usersState.copy(
                            users = null,
                            isLoading = false,
                            error = result.exceptionOrNull()?.message
                        )
                    }
                }
            }
        }
    }

}