package com.example.onlineshop.presentation.ui.screen.profile.requirement

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.presentation.ui.them.background
import com.example.onlineshop.presentation.ui.viewmodel.ShopViewModel

@Composable
fun UserProfileScreen(navController: NavController) {
    val shopViewModel: ShopViewModel = hiltViewModel()
    val user = shopViewModel.user.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize().background(background)
    ) {
        user.value?.let { user -> ProfileCard(user)}
        MenuGrid(navController)
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewProfile(){
    UserProfileScreen(rememberNavController())
}