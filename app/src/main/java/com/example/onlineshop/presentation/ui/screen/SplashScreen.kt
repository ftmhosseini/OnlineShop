package com.example.onlineshop.presentation.ui.screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController, modifier: Modifier = Modifier) {

    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 200,
            easing = { OvershootInterpolator(2f).getInterpolation(it) })
    )
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.popBackStack()
        navController.navigate(Screen.LoginScreen.route)
//        navController.navigate(Screen.HomeScreen.route)
    }

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

            modifier = Modifier.size(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = modifier
                    .alpha(scale)
                    .size(200.dp)
                    .aspectRatio(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.online_shop),
                contentDescription = "logo",
                modifier = modifier
                    .alpha(scale)
                    .width(200.dp)
                    .aspectRatio(1f)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSplash(){
    SplashScreen(rememberNavController())
}