package com.example.onlineshop.presentation.ui.screen.profile.requirement

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onlineshop.R

@Composable
fun MenuGrid(navController: NavController) {
    val items = listOf(
        Pair("سفارشات من", R.drawable.shopping_cart),
        Pair( "تجربه های خرید من", R.drawable.favorit),
        Pair("اعلان‌های من", R.drawable.password),
        Pair("تغییر رمز عبور", R.drawable.notif),
        Pair( "آدرس‌های من", R.drawable.bookmark),
        Pair( "علاقه‌مندی‌های من", R.drawable.location),
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp), // Or any fixed height you like
            contentPadding = PaddingValues(32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items.size) { item ->
            Card(
                shape = RoundedCornerShape(12.dp),
//                elevation = CardDefaults.cardElevation(4.dp),
                modifier = Modifier.fillMaxWidth().clickable {
//                    val route = getProfileRoute(item)
//                    if (route.isNotBlank()) {
//                        navController.navigate(route)
//                    }
                }
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(16.dp)
                        .fillMaxWidth()
                        .aspectRatio(1f), // makes height equal to width,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(painter = painterResource(items[item].second), contentDescription = null, tint = Color.Unspecified, modifier = Modifier.size(70.dp)) // replace with correct icons
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = items[item].first, textAlign = TextAlign.Center)
                }
            }
        }
    }
}
