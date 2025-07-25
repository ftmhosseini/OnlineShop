package com.example.onlineshop.presentation.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.onlineshop.R
import com.example.onlineshop.domain.model.GroupInfo
import com.example.onlineshop.domain.model.secondLevelGroup
import com.example.onlineshop.domain.model.topLevelGroup
import com.example.onlineshop.presentation.ui.bar.setLevel
import com.example.onlineshop.presentation.ui.screen.Screen
import com.example.onlineshop.presentation.ui.viewmodel.ShopViewModel

@Composable
fun ProductBanner(index: Int, navController: NavController) {
    val shopViewModel: ShopViewModel = hiltViewModel()
    shopViewModel.getProduct(index)
    val productState = shopViewModel.product.collectAsState()
    productState.value?.let{product ->
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .background(Color.LightGray, RoundedCornerShape(20.dp))
                .clickable {
                    navController.navigate("${Screen.ProductScreen.route}/$index")
                },
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier
                    .width(250.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(165.dp)
                        .padding(bottom = 5.dp)
                )
                ProductInfo(product)
            }
            if (product.discount > 0) {
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "  ${product.discount}%",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 20.dp)
                        .background(Color.Red, RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp))
                        .padding(horizontal = 4.dp, vertical = 5.dp)
                )
            }
        }
    }
}

@Composable
fun GroupBanner(group: GroupInfo, navController: NavController, index: Int, level: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(14.dp))
            .padding(16.dp)
            .clickable {

                setLevel(level)
                navController.navigate("${Screen.CategoryScreen.route}/$level/$index")

            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = group.image),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .padding(bottom = 5.dp),
        )
        Text(group.title, fontSize = 14.sp)
    }
}

@Composable
fun SmallGroupBanner(group: GroupInfo, index: Int = -1) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(
                width = 2.dp,
                color = if (topLevelGroup[index].image == group.image || secondLevelGroup[index].image == group.image)
                    Color.Red
                else
                    Color.White, shape = RoundedCornerShape(14.dp)
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = group.image),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .padding(bottom = 5.dp),
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToSaturation(
                    if (index != -1) {
                        if (topLevelGroup[index].image == group.image || secondLevelGroup[index].image == group.image)
                            1f
                        else
                            0f
                    } else 1f
                )
            })
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductBanner() {
//    val sharedProductViewModel: SharedProductViewModel = viewModel()
//    val product = FakeData.productList.last()
//    ProductBanner(viewModel = sharedProductViewModel, product = product, navController = rememberNavController())
}