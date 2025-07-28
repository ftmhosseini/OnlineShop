package com.example.onlineshop.presentation.ui.screen.category


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.domain.model.topLevelGroup
import com.example.onlineshop.presentation.ui.screen.home.GroupBanner
import com.example.onlineshop.presentation.ui.screen.home.ViewBanner
import com.example.onlineshop.presentation.ui.them.background

@Composable
fun Grouping(navController: NavController){
    Column(
        Modifier.fillMaxSize().background(background).padding(16.dp)
    ) {
        ViewBanner()
        Spacer(Modifier.height(25.dp))
        Text(
            text = "دسته بندی",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth().height(300.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(topLevelGroup.size) { index ->
                GroupBanner(topLevelGroup[index], navController, index, level = 0)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMain(){
    Grouping(rememberNavController())
}