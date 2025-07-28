package com.example.onlineshop.presentation.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun MyAddress(items: List<Address>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(
                horizontal = 24.dp,
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 70.dp)
        ) {
            Spacer(Modifier.height(32.dp))
            Text("آدرس های من", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(24.dp))
            for (i in items.indices) {
                AddressBar(items[i])
                Spacer(Modifier.height(16.dp))
            }
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Text(
                "+ ثبت آدرس جدید",
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyAddress() {
}