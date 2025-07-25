package com.example.onlineshop.presentation.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.domain.model.Product
import com.example.onlineshop.presentation.ui.screen.product.PriceSection

@Composable
fun ProductInfo(product: Product) {
    Box(
        modifier = Modifier
            .width(250.dp)
            .padding(vertical = 16.dp, horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(12.dp))
                .padding(10.dp),
        ) {
            Text(
                product.name, style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start
                )
            )
            Spacer(Modifier.height(10.dp))
            PriceSection(product.price, product.discount)
        }
        Icon(
            Icons.Outlined.Add,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.CenterEnd) // Aligns to the vertical center of the left edge
                .offset(x = 20.dp) // Move it right to pass halfway into column
                .background(Color.Red, CircleShape)
                .padding(8.dp)
        )
    }
}