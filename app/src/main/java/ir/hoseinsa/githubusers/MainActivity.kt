package ir.hoseinsa.githubusers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ir.hoseinsa.githubusers.ui.theme.GithubUsersTheme
import ir.hoseinsa.presenter.navigation.AppNavHost
import ir.hoseinsa.presenter.navigation.NavItem
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubUsersTheme {
                val scope = rememberCoroutineScope()
                val snackBarState = remember { SnackbarHostState() }
                Scaffold(
                    snackbarHost = { SnackbarHost(hostState = snackBarState) }
                ) { innerPadding ->
                    AppNavHost(
                        modifier = Modifier.padding(innerPadding),
                        startDestination = NavItem.UsersScreen.route,
                        showSnackBar = { message ->
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