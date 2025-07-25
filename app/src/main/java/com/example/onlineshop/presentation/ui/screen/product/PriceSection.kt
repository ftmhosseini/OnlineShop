package com.example.onlineshop.presentation.ui.screen.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.domain.model.Product
import com.example.onlineshop.domain.model.BasketItem
import com.example.onlineshop.presentation.ui.viewmodel.BasketViewModel

@Composable
fun PriceSection(price: Long, discount: Int = 0) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        if (discount > 0) {
            Text(
                text = price.toString(),
                style = TextStyle(
                    textDecoration = TextDecoration.LineThrough,
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            val newPrice = price * (1 - discount.toDouble() / 100)
            Text(
                text = "${newPrice.toInt()} تومان",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
        } else
            Text(text = "${price.toInt()} تومان", fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Composable
fun AddToCartSection(product: Product, viewModel: BasketViewModel) {
    val text = remember { mutableIntStateOf(1) }
    val message = remember { mutableStateOf("") }
    Text(message.value, color = Color.Red)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = { text.intValue++ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(4.dp),
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
            Text(text.intValue.toString(), modifier = Modifier.padding(8.dp))
            Button(
                onClick = { if (text.intValue > 1) text.intValue-- },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(4.dp),
            ) {
                Icon(Icons.Default.Delete, contentDescription = null)
            }
        }
        Button(
            onClick = {
                val item = BasketItem(
                    productName = product.name,
                    price = product.price,
                    discount = product.discount,
                    quantity = text.intValue,
                    imageRes = product.image // replace with actual image ID
                )
                viewModel.addItem(item)
                message.value = " added this item to basket"
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(
                text = "افزودن به سبد خرید",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
