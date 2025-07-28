package com.example.onlineshop.presentation.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.domain.model.Address
import com.example.onlineshop.presentation.ui.screen.profile.requirement.AddressBar
import com.example.onlineshop.presentation.ui.them.background

@Composable
fun EditAddress(items: List<Address>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(
                bottom = 24.dp,
                start = 24.dp,
                end = 24.dp
            )
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 100.dp)
        ) {
            Spacer(Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("آدرس های من", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
                Icon(
                    Icons.AutoMirrored.Default.ArrowForward,
                    contentDescription = "",
                    tint = Color.Red,
                    modifier = Modifier.clickable { }
                )
            }
            Spacer(Modifier.height(24.dp))
            Text(
                "آدرس مورد نظر خود را انتخاب کنید.", modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            for (i in items.indices) {
                AddressBar(items[i])
                Spacer(Modifier.height(16.dp))
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 2.dp, shape = RoundedCornerShape(8.dp), color = Color.Red)
                    .background(color = Color.Transparent, shape = RoundedCornerShape(8.dp))
            ) {
                Text("+ ثبت آدرس جدید", fontWeight = FontWeight.ExtraBold, color = Color.Red)
            }
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Red, shape = RoundedCornerShape(8.dp))
                .align(Alignment.BottomCenter)
        ) {
            Text(
                "انتخاب آدرس و ادامه خرید",
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddress() {
}