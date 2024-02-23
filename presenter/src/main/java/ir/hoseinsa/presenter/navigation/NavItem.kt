package ir.hoseinsa.presenter.navigation


sealed class NavItem(val route: String) {

    data object UsersScreen: NavItem(route = "UsersScreen")
    data class UserDetailsScreen(val username: String? = null) : NavItem(route = "UserScreen/$username")

}
