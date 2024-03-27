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
    showSnackBar: (String) -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController, startDestination = startDestination
    ) {
        composable(NavItem.UsersScreen.route) {
            UsersScreen(
                navigateToUserDetail = {
                    navController.navigate(NavItem.UserDetailsScreen.createRoute(it))
                },
            )
        }
        composable(NavItem.UserDetailsScreen.route) {
            val username = it.arguments?.getString(NavItem.USERNAME)
            DetailsScreen(
                username = username,
                showSnackBar = showSnackBar,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}