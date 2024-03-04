package ir.hoseinsa.presenter.navigation



sealed class NavItem(val route: String) {
    companion object {
        const val USERNAME = "username"
    }
    data object UsersScreen: NavItem(route = "UsersScreen")

    data object UserDetailsScreen : NavItem(route = "UserScreen/{$USERNAME}") {
        fun createRoute(username: String) = "UserScreen/$username"
    }

}