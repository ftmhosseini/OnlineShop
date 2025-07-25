package com.example.onlineshop.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.presentation.ui.bar.BottomBar
import com.example.onlineshop.presentation.ui.bar.BottomNavState
import com.example.onlineshop.presentation.ui.bar.TopBar
import com.example.onlineshop.presentation.ui.bar.getBottomItems
import com.example.onlineshop.presentation.ui.bar.getScreenRoute
import com.example.onlineshop.presentation.ui.bar.setBottomNavState
import com.example.onlineshop.presentation.ui.screen.category.Category
import com.example.onlineshop.presentation.ui.screen.category.CategorySecondLevel
import com.example.onlineshop.presentation.ui.screen.category.Grouping
import com.example.onlineshop.presentation.ui.screen.home.Home
import com.example.onlineshop.presentation.ui.screen.product.ProductScreen
import com.example.onlineshop.presentation.ui.screen.profile.requirement.UserProfileScreen
import com.example.onlineshop.presentation.ui.them.background
import com.example.onlineshop.presentation.ui.viewmodel.BasketViewModel
import com.example.onlineshop.presentation.ui.viewmodel.ShopViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    index: Int = -1,//product index
    topIndex: Int = -1,//top level group index
    level: Int = -1,//top level of group index
) {

//    val context = LocalContext.current
//    val db = Room.databaseBuilder(context, AppDatabase::class.java, "my_db").build()
//    val viewModel = remember { BasketViewModel(db.basketDao()) }
    val basketViewModel: BasketViewModel = hiltViewModel()
    val shopViewModel: ShopViewModel = hiltViewModel()
    val user = shopViewModel.user.collectAsState()
    Scaffold(topBar = {
        TopBar(
            navController = navController, user = user.value
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
                                shopViewModel.getProducts()
                                val products = shopViewModel.products.collectAsState()
                                products.value.firstOrNull()?.let { product ->
                                    ProductScreen(product = product, viewModel = basketViewModel)
                                }

                            } else when (BottomNavState.value.intValue) {
                                0 -> {//profile
                                    UserProfileScreen(navController)
                                }

                                1 -> {//basket
                                    BasketScreen(viewModel = basketViewModel)
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