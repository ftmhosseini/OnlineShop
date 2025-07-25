package com.example.onlineshop.presentation.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onlineshop.domain.model.Banner
import com.example.onlineshop.data.remote.getBannerContent
import com.example.onlineshop.presentation.ui.them.GreenBackground
import com.example.onlineshop.presentation.ui.them.background
import kotlinx.coroutines.launch

@Composable
fun ViewBanner() {
    val banner = getBannerContent()
    val pagerState = rememberPagerState(pageCount = { banner.size })
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        HorizontalPager(
            verticalAlignment = Alignment.CenterVertically,
            state = pagerState,
            modifier = Modifier
                .wrapContentSize()
        ) { currentPage ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Card(
                    Modifier.wrapContentSize(),
//                    elevation = CardDefaults.cardElevation(8.dp),
                ) {
                    Banner(banner = banner[currentPage])
                }
            }
        }
        Icon(
            modifier = Modifier
                .height(45.dp)
                .width(15.dp)
                .offset(x = (5).dp)
                .background(background, shape = RoundedCornerShape(8.dp))
                .align(Alignment.CenterEnd)
                .clickable {
                    val nextPage = if (pagerState.currentPage < banner.size - 1)
                        pagerState.currentPage + 1
                    else
                        (pagerState.currentPage + 1) % banner.size
                    if (nextPage < banner.size) {
                        scope.launch { pagerState.scrollToPage(nextPage) }
                    }
                },
            imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
            contentDescription = "",
            tint = Color.Black
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "",
            modifier = Modifier
                .height(45.dp)
                .width(15.dp)
                .offset(x = (-5).dp)
                .background(background, shape = RoundedCornerShape(8.dp))
                .align(Alignment.CenterStart)
                .clickable {
                    val previousPage = if (pagerState.currentPage > 0)
                        pagerState.currentPage - 1
                    else
                        banner.size - 1
                    if (previousPage >= 0) {
                        scope.launch { pagerState.scrollToPage(previousPage) }
                    }
                },
            tint = Color.Black
        )
        Text(
            text ="تخفیف ویژه" ,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(horizontal = 28.dp)
                .offset(y = (-15).dp)
                .background(Color.Red, RoundedCornerShape( 15.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun Banner(banner: Banner) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .background(background)
//            .padding(16.dp)
            .background(GreenBackground, shape = RoundedCornerShape(8.dp)) // softer green
            .padding(vertical = 16.dp, horizontal = 32.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color.Yellow.copy(alpha = 0.5f),
                            Color.Transparent
                        ),
                        radius = 150f
                    ),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(banner.image),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                banner.title,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White
            )
            Text(
                banner.content,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBanner() {
    ViewBanner()
}