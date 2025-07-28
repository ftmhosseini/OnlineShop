package com.example.onlineshop.presentation.ui.screen.product

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.domain.model.Product

@Composable
fun TabSection(product: Product) {
    val tabs = listOf("توضیحات", "ویژگی‌ها", "نظرات", "محصولات مشابه")
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val shape = RoundedCornerShape(10.dp)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Color.White)
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = product.name,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White,
            edgePadding = 14.dp,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = Color.Red
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(
                            title,
                            color = if (selectedTabIndex == index) Color.Red else Color.Gray
                        )
                    }
                )
            }
        }

        Spacer(Modifier.height(16.dp))
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "توضیحات",
            fontWeight = FontWeight.ExtraBold
        )
        Text(modifier = Modifier.padding(horizontal = 16.dp), text = product.description)
        if (product.features.isNotEmpty()) {
            Spacer(Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "ویژگی\u200Cها",
                fontWeight = FontWeight.ExtraBold
            )
            for (i in product.features.indices) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                        .background(
                            if (i % 2 == 0) Color.LightGray else Color.White,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = product.features[i].type
                    )
                    Text(text = ": ")
                    Text(text = product.features[i].value)

                }
            }
        }
    }
    Spacer(Modifier.height(48.dp))
    Opinion()
    if (product.opinion.isNotEmpty()) {
        Spacer(Modifier.height(48.dp))
        Text(
//            modifier = Modifier.padding(horizontal = 16.dp),
            text = "نظرات کاربران",
            fontWeight = FontWeight.ExtraBold
        )
        Column(
            modifier = Modifier
//                .padding(16.dp)
                .fillMaxWidth()
                .clip(shape)
                .background(Color.White)
                .border(
                    width = 2.dp,
                    color = Color.White,
                    shape = shape
                ),
        ) {
            for (i in product.opinion.indices) {
                if (product.opinion[i].hasAnswered.isNotEmpty()) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .clip(shape)
                            .background(Color.White)
                            .border(
                                width = 2.dp,
                                color = Color.LightGray,
                                shape = shape
                            ),
                    ) {
                        OpinionScreen(product.opinion[i])

                        for (index in product.opinion[i].hasAnswered.indices) {
                            OpinionScreen(product.opinion[i].hasAnswered[index])
                        }
                    }
                } else
                    OpinionScreen(product.opinion[i])
            }
        }
    }
//    Text(modifier = Modifier.padding(horizontal = 16.dp), text = product.opinion.toString())

}
