package com.example.onlineshop.presentation.ui.screen.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.onlineshop.domain.model.Product
import com.example.onlineshop.presentation.ui.them.background

@Composable
fun ProductInfoSection(product: Product) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.LightGray, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.TopEnd
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(background, RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp, topStart = 8.dp))

        ) {
            TabSection(product)

        }
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .width(150.dp)
                .offset(y = (-32).dp)
                .background(Color.White, RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Share, contentDescription = "")
            Text(product.rate.toString())
            Icon(Icons.Default.Star, contentDescription = "")
            Icon(Icons.Outlined.ThumbUp, contentDescription = "")
            Icon(Icons.Outlined.Home, contentDescription = "")
        }
    }
}
