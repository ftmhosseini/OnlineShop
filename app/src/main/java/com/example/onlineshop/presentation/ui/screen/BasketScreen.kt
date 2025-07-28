package com.example.onlineshop.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.presentation.ui.screen.product.PriceSection
import com.example.onlineshop.presentation.ui.viewmodel.BasketViewModel
import com.example.onlineshop.presentation.ui.them.background

@Composable
fun CalculateCard(viewModel: BasketViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 15.dp,
                shape = RoundedCornerShape(topEnd = 48.dp, topStart = 48.dp)
            )
//            .clip(RoundedCornerShape(bottomEnd = 48.dp, bottomStart = 48.dp))
            .background(Color.White).padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(Modifier.padding(16.dp)) {
            SummaryRow("جمع قیمت:", "${viewModel.getTotalPrice()} تومان")
            SummaryRow("تخفیف:", "${viewModel.getTotalDiscount()} تومان", color = Color.Red)
            Spacer(Modifier.height(16.dp))
            SummaryRow(
                "مبلغ نهایی:",
                "${viewModel.getFinalAmount()} تومان",
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = { /* Continue purchase */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("ادامه خرید", color = Color.White)
            }
        }
    }
}
@Composable
fun BasketScreen(viewModel: BasketViewModel) {
    val items by viewModel.items.collectAsState()
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Spacer(Modifier.height(16.dp))
        Text("سبد خرید", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(items.size) { index ->
                Card(
                    modifier = Modifier.padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.background(
                                background,
                                shape = RoundedCornerShape(7.dp)
                            )
                        ) {
                            IconButton(onClick = { viewModel.increase(items[index]) }) {
                                Icon(Icons.Default.Add, contentDescription = "")
                            }
                            Text(items[index].quantity.toString(), fontWeight = FontWeight.Bold)
                            IconButton(onClick = { viewModel.decrease(items[index]) }) {
                                Icon(Icons.Default.Delete, contentDescription = "")
                            }
                        }
                        Image(
                            painter = painterResource(id = items[index].imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(90.dp)
                                .background(Color.LightGray, shape = RoundedCornerShape(10.dp))
                        )
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 12.dp)
                        ) {
                            Text(text = items[index].productName, fontWeight = FontWeight.Bold)
                            PriceSection(items[index].price,items[index].discount)
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(16.dp))

        CalculateCard(viewModel)
    }
}

@Composable
fun SummaryRow(
    label: String,
    value: String,
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontWeight = fontWeight)
        Text(value, fontWeight = fontWeight, color = color)
    }
}
