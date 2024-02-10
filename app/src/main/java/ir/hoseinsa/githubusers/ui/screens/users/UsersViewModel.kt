package ir.hoseinsa.githubusers.ui.screens.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.hoseinsa.githubusers.domain.usecases.UsersDomain
import ir.hoseinsa.githubusers.ui.datastate.DataState
import ir.hoseinsa.githubusers.ui.intent.DataIntent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class UsersViewModel(private val usersDomain: UsersDomain) : ViewModel() {

    val dataIntent = Channel<DataIntent>(Channel.UNLIMITED)
    var usersState by mutableStateOf(UsersState())
        private set

    init {
        handleIntent()
    }

    private fun handleIntent() = dataIntent.consumeAsFlow().onEach { dataIntent ->
        when (dataIntent) {
            is DataIntent.GetUsers -> getUsers()
        }
    }.launchIn(viewModelScope)


    fun sendIntent() = viewModelScope.launch {
        dataIntent.send(DataIntent.GetUsers)
    }


    private fun getUsers() {
        viewModelScope.launch {
            usersState = usersState.copy(
                users = null,
                isLoading = true,
                error = null
            )
            usersDomain.users.getUsers().onEach { result ->
                when (result) {
                    is DataState.Success -> {
                        usersState = usersState.copy(
                            users = result.data,
                            isLoading = false,
                            error = null
                        )
                    }

                    is DataState.Error -> {
                        usersState = usersState.copy(
                            users = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

}