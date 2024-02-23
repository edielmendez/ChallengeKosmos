package mx.com.mvtech.kosmoschallenge.ui.screens.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import mx.com.mvtech.kosmoschallenge.ui.screens.home.HomeScreen

const val homeNavigationRoute = "home_screen_route"

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) = navigate(homeNavigationRoute, navOptions)

fun NavGraphBuilder.homeScreen() {
    composable(
        route = homeNavigationRoute,
    ) {
        HomeScreen()
    }
}