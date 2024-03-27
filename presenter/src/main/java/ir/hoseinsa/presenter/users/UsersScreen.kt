package ir.hoseinsa.presenter.users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import ir.hoseinsa.presenter.R
import ir.hoseinsa.presenter.components.GitHubUsersTopAppBar
import ir.hoseinsa.presenter.users.components.MessageComponent
import ir.hoseinsa.presenter.users.components.UserItemComponent
import ir.hoseinsa.presenter.users.components.UserItemComponentLoading
import ir.hoseinsa.presenter.users.intent.UsersScreenEvent
import org.koin.androidx.compose.koinViewModel

@Composable
fun UsersScreen(
    navigateToUserDetail: (String) -> Unit,
    usersViewModel: UsersViewModel = koinViewModel(),
) {
    val state = usersViewModel.state
    val usersListState = usersViewModel.state.userItems?.collectAsLazyPagingItems()
    val refreshLoadState = usersListState?.loadState?.refresh
    LaunchedEffect(key1 = true) {
        usersViewModel.onEvent(UsersScreenEvent.GetUsers)
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
            when {
                state.isOnline.not() -> {
                    MessageComponent(
                        title = stringResource(R.string.disconnected_all),
                        description = stringResource(R.string.check_your_connection_all)
                    )
                }
                else -> {
                    LazyColumn {
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
                                item {
                                    MessageComponent(
                                        title = "An error occurred",
                                        description = refreshLoadState.error.message ?: "That's all what i know :("
                                    )
                                }
                            }

                            else -> {}
                        }

                    }
                }
            }
        }
    }
}