package com.example.onlineshop.presentation.ui.screen.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.domain.model.secondLevelGroup
import com.example.onlineshop.presentation.ui.screen.home.ProductBanner
import com.example.onlineshop.presentation.ui.screen.home.SmallGroupBanner
import com.example.onlineshop.presentation.ui.viewmodel.ShopViewModel

@Composable
fun CategorySecondLevel(navController: NavController, selectedIndex:Int = -1){
    val shopViewModel: ShopViewModel = hiltViewModel()
    shopViewModel.getProducts()
    val products = shopViewModel.products.collectAsState()
    var text by remember { mutableStateOf("") }
    Column(
        Modifier.padding(16.dp)
            .fillMaxSize()
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(secondLevelGroup.size) { index ->
                SmallGroupBanner(secondLevelGroup[index],selectedIndex)
            }
        }
        Spacer(Modifier.height(25.dp))
        Text(
            text = secondLevelGroup[selectedIndex].title,
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold
        )
        TextField(
            value = text,
            onValueChange = { text = it },
            placeholder = {
                Row {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "",
                        tint = Color.Red
                    )
                    Text(text = " هرچی میخوای جستجوکن ...")
                }
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
                .padding(top = 15.dp),
            shape =
            RoundedCornerShape(12.dp)

        )
        Spacer(Modifier.height(15.dp))
        Text(
            secondLevelGroup[selectedIndex].title,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth().height(500.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(products.value.size) { index ->
                ProductBanner(index, navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategory(){
    CategorySecondLevel(rememberNavController())
}