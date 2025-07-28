package com.example.onlineshop.presentation.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.domain.model.User
import com.example.onlineshop.presentation.ui.screen.profile.requirement.SmallProfileCard
import com.example.onlineshop.presentation.ui.them.background

@Composable
fun ChangePassword(user: User) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        SmallProfileCard(user)
        Spacer(Modifier.height(32.dp))

        Text(
            "تغییر رمز", modifier = Modifier
                .padding(horizontal = 32.dp), fontWeight = FontWeight.ExtraBold, fontSize = 24.sp
        )
        Text(
            "در انتخاب رمز عبور موارد زیر را در نظر بگیرید:\n" +
                    "رمز عبور باید خداقل 8 کارکتر باشد\n" +
                    "شامل حروف و عدد باشد\n" +
                    "شامل علامت باشد(!@#\$%)\n" +
                    "از حروف بزرگ و کوچک استفاده شود.",
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 32.dp)
        )
        Spacer(Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp)
        ) {
            Text("رمز عبور فعلی:", fontWeight = FontWeight.Bold)
            Text("*", color = Color.Red, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(8.dp))
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,

                ),
        )
        Spacer(Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp)
        ) {
            Text("رمز عبور جدید:", fontWeight = FontWeight.Bold)
            Text("*", color = Color.Red, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(8.dp))
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,

                ),
        )
        Spacer(Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp)
        ) {
            Text("تکرار رمز عبور جدید:", fontWeight = FontWeight.Bold)
            Text("*", color = Color.Red, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(8.dp))
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,

                ),
        )
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .background(color = Color.Red, shape = RoundedCornerShape(8.dp))
        ) {
            Text("تغییر رمز عبور", fontWeight = FontWeight.Bold)
        }
    }
}