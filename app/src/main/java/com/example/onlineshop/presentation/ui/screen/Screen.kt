package com.example.onlineshop.presentation.ui.screen

sealed class Screen (val route:String){
    data object SplashScreens : Screen("splash")
    data object LoginScreen : Screen("login")
    data object ConfirmScreen : Screen("confirm")
    data object CodeScreen : Screen("submit_code")
    data object HomeScreen : Screen("home")
    data object ProductScreen : Screen("product_detail")
    data object ProfileScreen : Screen("profile")
    data object BasketScreen : Screen("basket")
    data object CategoryScreen : Screen("category")
    data object ChangePassword : Screen("password")
    data object MyAddressBar : Screen("address")
}