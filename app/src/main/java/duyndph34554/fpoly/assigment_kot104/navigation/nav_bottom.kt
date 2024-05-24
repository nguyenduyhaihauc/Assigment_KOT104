package duyndph34554.fpoly.assigment_kot104.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import duyndph34554.fpoly.assigment_kot104.screen.CarScreen
import duyndph34554.fpoly.assigment_kot104.screen.FavouriteScreen
import duyndph34554.fpoly.assigment_kot104.screen.Home
import duyndph34554.fpoly.assigment_kot104.screen.HomeScreen
import duyndph34554.fpoly.assigment_kot104.screen.NotificationScreen
import duyndph34554.fpoly.assigment_kot104.screen.ProfileScreen


@Composable
fun bottom_navhost (navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(nav = navController) }
        composable("notification") { NotificationScreen(navController) }
        composable("favourite") { FavouriteScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("cart") { CarScreen(navController = navController) }
    }
}