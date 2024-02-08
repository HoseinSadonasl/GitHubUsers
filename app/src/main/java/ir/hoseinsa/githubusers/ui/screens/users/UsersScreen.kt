package ir.hoseinsa.githubusers.ui.screens.users

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.hoseinsa.githubusers.ui.components.UserItemComponent
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel


@Composable
fun UsersScreen(
    usersViewModel: UsersViewModel = koinViewModel(),
    showSnackBar: (String) -> Unit = {}
) {
    LaunchedEffect(key1 = true) {
        usersViewModel.sendIntent()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (usersViewModel.usersState.isLoading) {
            CircularProgressIndicator()
        } else if (!usersViewModel.usersState.error.isNullOrBlank()) {
            showSnackBar(usersViewModel.usersState.error!!)
        } else LazyColumn(
            contentPadding = PaddingValues(8.dp),
            state = rememberLazyListState()
        ) {
            val users = usersViewModel.usersState.users
            if (users == null) {
                item {
                    Text(text = "No data!")
                }
            } else {
                items(users.size) {
                    users.forEach { user ->
                        UserItemComponent(user)
                    }
                }
            }
        }
    }
}