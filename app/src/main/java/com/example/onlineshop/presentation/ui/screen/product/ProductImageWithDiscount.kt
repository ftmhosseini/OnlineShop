package com.example.onlineshop.presentation.ui.screen.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProductImageWithDiscount(image: Int, discount: Int) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .background(Color.LightGray, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.TopStart) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
        )
        if (discount > 0) {
            Spacer(Modifier.height(10.dp))
            Text(
                text = "$discount%",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(vertical = 14.dp)
                    .background(Color.Red, RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}
