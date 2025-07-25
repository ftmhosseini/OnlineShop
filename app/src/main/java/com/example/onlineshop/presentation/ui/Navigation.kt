package com.example.onlineshop.presentation.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.onlineshop.presentation.ui.screen.HomeScreen
import com.example.onlineshop.presentation.ui.screen.Screen
import com.example.onlineshop.presentation.ui.screen.SplashScreen
import com.example.onlineshop.presentation.ui.screen.login.ConfirmProgress
import com.example.onlineshop.presentation.ui.screen.login.LoginScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreens.route) {
        composable(Screen.SplashScreens.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController, route = Screen.LoginScreen.route)
        }
        composable(
            route = "${Screen.ConfirmScreen.route}/{email}",
            arguments = listOf(navArgument("email") { type = NavType.StringType })
        ) { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email")
            ConfirmProgress(navController = navController, email = email.toString())
        }
        composable(Screen.CodeScreen.route) {
            LoginScreen(navController = navController, route = Screen.CodeScreen.route)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(Screen.ProfileScreen.route) {
            HomeScreen(navController)
        }
        composable(Screen.BasketScreen.route) {
            HomeScreen(navController)
        }

        composable(
            route = "${Screen.ProductScreen.route}/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ) {
            val index = it.arguments?.getInt("index")
            HomeScreen(navController, index = index!!.toInt())
        }
        composable(
            route = "${Screen.CategoryScreen.route}/{level}/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType },
                navArgument("level") { type = NavType.IntType })
        ) {
            val index = it.arguments?.getInt("index")?:-1
            val level = it.arguments?.getInt("level")?:-1
            Log.i("TAGTAG", "Navigation: $index")
            HomeScreen(navController, topIndex = index, level = level)
        }

    }
}