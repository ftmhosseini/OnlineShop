package com.example.onlineshop.presentation.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.R
import com.example.onlineshop.presentation.ui.screen.Screen
import kotlinx.coroutines.delay

@Composable
fun ConfirmProcess(
    navController: NavController,
    email: String
) {
    val resultNeeded = 222660
    var timeLeftMillis by remember { mutableLongStateOf(120_000L) } // 2minutes, //60 seconds
    var isTimerRunning by remember { mutableStateOf(true) }
    val seconds = ((timeLeftMillis / 1000) % 60).toString().padStart(2, '0')
    val minutes = (timeLeftMillis / 1000 / 60).toString().padStart(2, '0')
//    val millis = ((timeLeftMillis % 1000) / 10).toString().padStart(2, '0') // Show 2-digit millis
//    val formattedTime = "$minutes:$seconds:$millis"
    val formattedTime = "$minutes:$seconds"
    var shouldVerifyCode by remember { mutableStateOf(false) }
    val isLoading = remember { mutableStateOf(false) }
    val message = remember { mutableStateOf("") }
    // Timer: updates every 100 ms
    LaunchedEffect(shouldVerifyCode) {
        if (shouldVerifyCode) {
            isLoading.value = true
            delay(2000L) // simulate network delay
            isLoading.value = false
            shouldVerifyCode = false
            navController.navigate(Screen.CodeScreen.route) {
                popUpTo(Screen.LoginScreen.route) { inclusive = true }
            }
        }
    }
    if (isLoading.value) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            androidx.compose.material3.CircularProgressIndicator(
                color = colorResource(R.color.dark_red),
                strokeWidth = 2.dp
            )
            Text(
                text = "در حال بررسی...",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically),
                color = Color.Gray
            )
        }
    } else {
        LaunchedEffect(isTimerRunning) {
            if (isTimerRunning) {
                while (timeLeftMillis > 0) {
                    delay(10L) // 100 milliseconds
                    timeLeftMillis -= 10
                }
                isTimerRunning = false
            }
        }
        Column {

            Text(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                text = "کد تائید:",
                modifier = Modifier.align(Alignment.Start)
            )
            Text(
                text = "کد 4 رقمی ارسال شده به $email خود را وارد کنید. "
            )
            val code = remember { mutableStateOf("") }
            TextField(
                value = code.value,
                onValueChange = { code.value = it },
                placeholder = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "کد تائید را وارد کنید")
                        Text(
                            formattedTime,
                            modifier = Modifier
                                .wrapContentWidth()
                                .background(
                                    colorResource(R.color.cream),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 15.dp)
                        )

                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                singleLine = true,

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
            if (message.value.isNotEmpty()) {
                Text(message.value, color = Color.Red)
            }
            Button(
                onClick = {
                    if (code.value.isEmpty()) {
                        message.value = "لطفاً کد را وارد کنید"
                        return@Button
                    } else {
                        if (code.value.toInt() == resultNeeded) {
                            shouldVerifyCode = true
//                        navController.navigate(Screen.CodeScreen.route) {
//                            popUpTo(Screen.LoginScreen.route) {
//                                inclusive = true
//                            }
//                        }
                        } else {
                            message.value = "کد وارد شده اشتباه است"
                        }
                    }
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, bottom = 10.dp)
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
                    text = "  تائید و ادامه",
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .background(Color.Transparent)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "  ویرایش ایمیل",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        navController.navigate(route = Screen.LoginScreen.route)
                    })
                Row(
                    modifier = Modifier.clickable {
                        timeLeftMillis = 6000L
                    }
                ) {
                    Text(
                        "  ارسال مجدد کد",
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        Icons.AutoMirrored.Default.ArrowForward,
                        contentDescription = ""
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConfirm() {
    val email = "ali@ali.co"
    ConfirmProcess(rememberNavController(), email)
}