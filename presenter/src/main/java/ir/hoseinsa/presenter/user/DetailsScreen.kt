package ir.hoseinsa.presenter.user

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.hoseinsa.presenter.components.CircularImageComponent
import ir.hoseinsa.presenter.components.GitHubUsersTopAppBar
import ir.hoseinsa.presenter.user.components.DetailsSection
import ir.hoseinsa.presenter.user.intent.UserDetailsScreenEvent
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    username: String?,
    userViewModel: UserViewModel = koinViewModel(),
    showSnackBar: (String) -> Unit = {},
    navigateBack: () -> Unit
) {
    val state = userViewModel.state

    LaunchedEffect(key1 = username) {
        username?.let {
            userViewModel.onEvent(UserDetailsScreenEvent.GetUser(username))
        }
    }

    Scaffold(
        topBar = {
            GitHubUsersTopAppBar(
                title = username ?: "Unknown",
                navigationIcon = Icons.AutoMirrored.Default.ArrowBack,
                onNavigationIconClick = navigateBack
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (state.isLoading) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else if (state.user != null) {
                CircularImageComponent(
                    imageUrl = state.user.avatarUrl, modifier = Modifier
                        .width(180.dp)
                        .height(180.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                DetailsSection(
                    user = state.user,
                )
            } else if (!state.error.isNullOrBlank()) {
                showSnackBar(state.error)
            }
        }
    }

}