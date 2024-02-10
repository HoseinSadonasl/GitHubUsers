package ir.hoseinsa.githubusers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ir.hoseinsa.githubusers.presenter.users.UsersScreen
import ir.hoseinsa.githubusers.ui.theme.GithubUsersTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubUsersTheme {
                val scope = rememberCoroutineScope()
                val snackBarState = remember { SnackbarHostState() }
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = stringResource(id = R.string.app_name)) },
                            actions = {
                                IconButton(
                                    onClick = {
                                        scope.launch {
                                            snackBarState.showSnackbar(
                                                message = "Hosein sadon asl"
                                            )
                                        }
                                    },
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.Info,
                                        contentDescription = "Information"
                                    )
                                }
                            },
                        )
                    },
                    snackbarHost = { SnackbarHost(hostState = snackBarState) }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                    UsersScreen(showSnackBar = { message ->
                        scope.launch {
                            snackBarState.showSnackbar(
                                message = message,
                                duration = SnackbarDuration.Long
                            )
                        }
                    })
                }
            }
        }
    }
}