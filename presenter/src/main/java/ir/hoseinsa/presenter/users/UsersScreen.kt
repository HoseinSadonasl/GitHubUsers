package ir.hoseinsa.presenter.users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.magnifier
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import ir.hoseinsa.presenter.components.GitHubUsersTopAppBar
import ir.hoseinsa.presenter.users.components.UserItemComponent
import ir.hoseinsa.presenter.users.components.UserItemComponentLoading
import org.koin.androidx.compose.koinViewModel

@Composable
fun UsersScreen(
    navigateToUserDetail: (String) -> Unit,
    usersViewModel: UsersViewModel = koinViewModel(),
    showSnackBar: (String) -> Unit = {}
) {
    val usersListState = usersViewModel.usersState.userItems?.collectAsLazyPagingItems()
    val refreshLoadState = usersListState?.loadState?.refresh
    LaunchedEffect(key1 = true) {
        usersViewModel.sendIntent()
    }
    Scaffold(
        topBar = {
            GitHubUsersTopAppBar(
                title = "GitHub Users"
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn {
                showSnackBar("Loaded")
                items(usersListState?.itemCount ?: 0) {
                    val item = usersListState?.get(it)
                    item?.let {
                        UserItemComponent(
                            userItem = item,
                            onUserClick = { navigateToUserDetail(it) }
                        )
                    }
                }

                when (refreshLoadState) {
                    is LoadState.Loading -> {
                        items(12) {
                            UserItemComponentLoading()
                        }
                    }

                    is LoadState.Error -> {
                        showSnackBar("ERROR")
                    }

                    is LoadState.NotLoading -> {
                        showSnackBar("NotLoading")
                    }

                    else -> {}
                }

            }
        }
    }
}