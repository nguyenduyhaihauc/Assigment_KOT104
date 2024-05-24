package duyndph34554.fpoly.assigment_kot104.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import duyndph34554.fpoly.assigment_kot104.screen.CarScreen
import duyndph34554.fpoly.assigment_kot104.screen.Home
import duyndph34554.fpoly.assigment_kot104.screen.LoginScreen
import duyndph34554.fpoly.assigment_kot104.screen.SignScreen
import duyndph34554.fpoly.assigment_kot104.screen.WelcomeScreen

@Composable
fun nav_main(navController: NavHostController) {
    
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome")  { WelcomeScreen(nanController = navController) }
        composable("login") { LoginScreen(navController = navController) }
        composable("sign") { SignScreen(navController = navController) }
        composable("home") { Home() }

    }
}