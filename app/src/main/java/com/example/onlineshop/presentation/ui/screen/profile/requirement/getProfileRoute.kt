package com.example.onlineshop.presentation.ui.screen.profile.requirement

import com.example.onlineshop.presentation.ui.screen.Screen


fun getProfileRoute(index:Int):String{
    return when (index) {
        0 -> Screen.MyAddressBar.route
        1 -> Screen.ChangePassword.route
        2 -> Screen.ChangePassword.route
        3 -> Screen.ChangePassword.route
        4 -> Screen.MyAddressBar.route
        5 -> Screen.MyAddressBar.route
        else -> "" // default case
    }
}