package ir.hoseinsa.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.hoseinsa.presenter.user.DetailsScreen
import ir.hoseinsa.presenter.users.UsersScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    screenTitle: (String?) -> Unit = {},
    showSnackBar: (String) -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController, startDestination = startDestination
    ) {
        composable("UsersScreen") {
            UsersScreen(navigateToUserDetail = { navController.navigate("UserScreen/$it") })
        }
        composable("UserScreen/{username}") {
            val username = it.arguments?.getString("username")
            DetailsScreen(
                username = username,
                screenTitle = { title -> screenTitle(title) },
                showSnackBar = showSnackBar
            )
        }
    }
}