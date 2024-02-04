package ir.hoseinsa.githubusers.ui.users

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.hoseinsa.githubusers.domain.models.user.UserPresenter
import ir.hoseinsa.githubusers.domain.usecases.UsersDomain
import ir.hoseinsa.githubusers.ui.datastate.DataState
import ir.hoseinsa.githubusers.ui.intent.DataIntent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class UsersViewModel(val usersDomain: UsersDomain) : ViewModel() {

    val dataIntent = Channel<DataIntent>(Channel.UNLIMITED)
    var usersState by mutableStateOf<DataState>(DataState.Idle)
        private set

    init {
        handleIntent()
    }

    private fun handleIntent() = viewModelScope.launch {
        dataIntent.consumeAsFlow().collect { dataIntent ->
            when (dataIntent) {
                is DataIntent.GetUsers -> getUsers()
            }
        }
    }

    private fun getUsers() {
        viewModelScope.launch {
            usersState = DataState.Loading
            usersDomain.users.getUsers().onEach { result ->
                usersState = result
            }.launchIn(viewModelScope)
        }
    }

}