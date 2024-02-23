package mx.com.mvtech.kosmoschallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import mx.com.mvtech.kosmoschallenge.ui.screens.home.navigation.homeNavigationRoute
import mx.com.mvtech.kosmoschallenge.ui.screens.home.navigation.homeScreen

@Composable
fun AppNavHost(
    startDestination: String = homeNavigationRoute
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        homeScreen(

        )
    }
}