package com.example.onlineshop.presentation.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.R
import com.example.onlineshop.presentation.ui.screen.Screen


@Composable
fun LoginScreen(
    navController: NavController,
    route: String,
    modifier: Modifier = Modifier,
    email: String = ""
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.spalsh_screen),
            contentDescription = "logo",
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds // STRETCH the image to fit width & height
        )
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.size(350.dp))
            {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo",
                    modifier = modifier
                        .size(150.dp)
                        .align(Alignment.TopCenter)
                        .aspectRatio(1f)
                )
                Image(
                    painter = painterResource(id = R.drawable.online_shop),
                    contentDescription = "logo",
                    modifier = modifier
                        .align(Alignment.Center)
                        .padding(bottom = 13.dp)
                        .width(200.dp)
                        .aspectRatio(1f)
                )
                Image(
                    painter = painterResource(id = R.drawable.persian_logo),
                    contentDescription = "logo",
                    modifier = modifier
                        .align(Alignment.BottomCenter)
                        .width(250.dp)
                        .aspectRatio(1f)
                )
            }
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                when (route) {
                    Screen.LoginScreen.route -> {
                        LoginProcess(navController)
                    }

                    Screen.ConfirmScreen.route -> {
                        ConfirmProcess(navController, email)
                    }

                    Screen.CodeScreen.route -> {
                        Text(
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth(),
                            text = "اطلاعات کاربری:",
                            fontWeight = FontWeight.ExtraBold
                        )
                        val name = remember { mutableStateOf("") }
                        TextField(
                            value = name.value,
                            onValueChange = { name.value = it },
                            placeholder = {
                                Text(text = "نام و نام خانوادگی خود را وارد کنید")
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
                                .padding(vertical = 15.dp)
                                .clip(
                                    RoundedCornerShape(12.dp)
                                )
                        )
                        Button(modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Red,
                                contentColor = Color.White
                            ),
                            onClick = {
                                navController.navigate(Screen.HomeScreen.route)
                            }) {
                            Text(
                                text = " ثبت اطلاعات",
                                fontWeight = FontWeight.ExtraBold,
                            )
                        }
                        Text(
                            text = "عبور از این مرحله",
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                                .clickable {
                                    navController.navigate(Screen.HomeScreen.route)
                                }
                        )
                    }

                    else -> {
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(rememberNavController(), route = Screen.LoginScreen.route)
//    LoginScreen(rememberNavController(), route = Screen.ConfirmScreen.route)
}