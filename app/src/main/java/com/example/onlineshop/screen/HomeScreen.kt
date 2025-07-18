package com.example.onlineshop.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.onlineshop.data.FakeData
import com.example.onlineshop.room.AppDatabase
import com.example.onlineshop.room.BasketViewModel
import com.example.onlineshop.screen.category.Category
import com.example.onlineshop.screen.category.CategorySecondLevel
import com.example.onlineshop.screen.category.Grouping
import com.example.onlineshop.screen.home.Home
import com.example.onlineshop.screen.product.ProductScreen
import com.example.onlineshop.screen.profile.requirement.UserProfileScreen
import com.example.onlineshop.ui.bar.BottomBar
import com.example.onlineshop.ui.bar.BottomNavState
import com.example.onlineshop.ui.bar.TopBar
import com.example.onlineshop.ui.bar.getBottomItems
import com.example.onlineshop.ui.bar.getScreenRoute
import com.example.onlineshop.ui.bar.setBottomNavState
import com.example.onlineshop.ui.them.background

@Composable
fun HomeScreen(
    navController: NavController,
    index: Int = -1,//product index
    topIndex: Int = -1,//top level group index
    level: Int = -1,//top level of group index
) {

    val context = LocalContext.current
    val db = Room.databaseBuilder(context, AppDatabase::class.java, "my_db").build()
    val viewModel = remember { BasketViewModel(db.basketDao()) }

    Scaffold(topBar = {
        TopBar(
            navController = navController, user = FakeData.user
        )
    }, bottomBar = {
        BottomBar(bottomItems = getBottomItems(),
            bottomNavState = BottomNavState.value,
            onItemSelected = { index ->
                setBottomNavState(index)
                navController.navigate(getScreenRoute(index)) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            })
    }) { innerPadding ->
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(background)
            ) {
                item {
                    when (level) {
                        0 -> {
                            Category(navController, topIndex)
                        }

                        1 -> {
                            CategorySecondLevel(navController, topIndex)
                        }

                        else -> {
                            if (index != -1) {
                                ProductScreen(FakeData.productList[index], viewModel)

                            } else when (BottomNavState.value.intValue) {
                                0 -> {//profile
                                    UserProfileScreen(navController)
                                }

                                1 -> {//basket
                                    BasketScreen(viewModel = viewModel)
                                }

                                2 -> {//category
                                    Grouping(navController)
                                }

                                3 -> {//home
                                    Home(navController)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(rememberNavController())
}