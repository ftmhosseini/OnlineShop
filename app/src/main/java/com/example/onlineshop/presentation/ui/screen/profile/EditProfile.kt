package com.example.onlineshop.presentation.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onlineshop.domain.model.User
import com.example.onlineshop.presentation.ui.screen.profile.requirement.MediumProfileCard
import com.example.onlineshop.presentation.ui.them.background

@Composable
fun EditProfile(user: User) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        MediumProfileCard(user)
        Spacer(Modifier.height(32.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp)
        ) {
            Text("نام و نام خانوادگی:", fontWeight = FontWeight.Bold)
            Text("*", color = Color.Red, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(8.dp))
        TextField(
            value = user.name,
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
            Text("شماره همراه:", fontWeight = FontWeight.Bold)
            Text("*", color = Color.Red, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(8.dp))
        TextField(
            value = user.phone,
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
        Text(
            "ایمیل:", fontWeight = FontWeight.Bold, modifier = Modifier
                .padding(horizontal = 32.dp)
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = user.email,
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
            placeholder = {
                Row {
                    Text("مثال: ")
                    Text(" bahramafshari@gmail.com")
                }
            }
        )
        Spacer(Modifier.height(24.dp))
        Text(
            "تاریخ تولد:", fontWeight = FontWeight.Bold, modifier = Modifier
                .padding(horizontal = 32.dp)
        )
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
        Text(
            "جنسیت:", fontWeight = FontWeight.Bold, modifier = Modifier
                .padding(horizontal = 32.dp)
        )
        Spacer(Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .padding(horizontal = 32.dp)
        ) {
            RadioButton(
                onClick = {},
                selected = false,
                colors = RadioButtonColors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Gray,
                    disabledSelectedColor = Color.Gray,
                    disabledUnselectedColor = Color.Gray
                )
            )
            Text("زن ", fontWeight = FontWeight.Bold)
            Spacer(Modifier.width(24.dp))
            RadioButton(
                onClick = {},
                selected = false,
                colors = RadioButtonColors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Gray,
                    disabledSelectedColor = Color.Gray,
                    disabledUnselectedColor = Color.Gray
                )
            )
            Text("مرد", fontWeight = FontWeight.Bold)
        }
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
            Text("ثبت تغییرات", fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEditProfile() {
}