package com.example.onlineshop.screen.profile.requirement

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.data.FakeData
import com.example.onlineshop.ui.them.background

@Composable
fun UserProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().background(background)
    ) {
        ProfileCard(FakeData.user)
        MenuGrid(navController)
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewProfile(){
    UserProfileScreen(rememberNavController())
}