package com.example.onlineshop.presentation.ui.screen.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.room.Room
import com.example.onlineshop.domain.model.Product
import com.example.onlineshop.data.room.AppDatabase
import com.example.onlineshop.presentation.ui.viewmodel.BasketViewModel
import com.example.onlineshop.presentation.ui.them.background
import com.example.onlineshop.presentation.ui.viewmodel.ShopViewModel

@Composable
fun ProductScreen(product: Product, viewModel: BasketViewModel) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(background)
                    .padding(bottom = 150.dp)
            ) {
                ProductImageWithDiscount(image = product.image, discount = product.discount)
                Spacer(Modifier.height(16.dp))
                ProductInfoSection(product)
            }
            Column(
                Modifier
                    .align(Alignment.BottomCenter)
                    .background(background)
                    .padding(top = 16.dp)
            ) {
                PriceSection(product.price, product.discount)
                AddToCartSection(product, viewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductScreen() {
    val context = LocalContext.current
    val db = Room.databaseBuilder(context, AppDatabase::class.java, "my_db").build()
    val fakeViewModel =  remember { BasketViewModel(db.basketDao()) }
//    ProductScreen(FakeData.productList.last(), fakeViewModel)
}