package com.example.onlineshop.presentation.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.R
import com.example.onlineshop.presentation.ui.screen.Screen

@Composable
fun LoginProcess(
    navController: NavController,
) {
    val email = remember { mutableStateOf("") }
    val message = remember { mutableStateOf("") }

    Column {

        Text(
            text = "جهت ورود به فروشگاه اینترنتی آنلاین شاپ ایمیل خود را در کادر زیر وارد کرده و کد ارسالی به ایمیل خود را در مرحله بعد وارد کنید."
        )
        Text(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            text = "ایمیل:",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 60.dp)
        )
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            placeholder = {
                Text(text = "ایمیل خود را وارد کنید")
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent, // ✅ remove underline when focused
                unfocusedIndicatorColor = Color.Transparent, // ✅ remove underline when not focused
                disabledIndicatorColor = Color.Transparent // ✅ optional for disabled state
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
                .clip(
                    RoundedCornerShape(12.dp)
                )
        )
        if (message.value.isNotEmpty()){
            Text(message.value, color = Color.Red)
        }
        Button(
            onClick = {
                if (email.value.contains('@') && email.value.contains('.') && email.value.length > 8)
                    navController.navigate("${Screen.ConfirmScreen.route}/${email.value}")
                else
                    message.value = "email format is wrong"
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorResource(R.color.light_red),
                            colorResource(R.color.dark_red)
                        ),
                        start = Offset(0f, 0f),
                        end = Offset.Infinite
                    ),
                    shape = RoundedCornerShape(12.dp)
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent // key for showing gradient
            )
        ) {
            Text(
                "  تائید و ادامه",
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.background(Color.Transparent)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    LoginProcess(rememberNavController())
}