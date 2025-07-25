package com.example.onlineshop.presentation.ui.bar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onlineshop.R
import com.example.onlineshop.domain.model.User
import com.example.onlineshop.domain.model.MenuItem
import com.example.onlineshop.presentation.ui.them.background

@Composable
fun getMenuItems() = listOf(
    MenuItem("پروفایل کاربری", R.drawable.user_profile),
    MenuItem("سفارشات من", R.drawable.purchased),
    MenuItem("پشتیبانی", R.drawable.support),
    MenuItem("قوانین و مقررات ", R.drawable.roles),
    MenuItem("درباره ما", R.drawable.about),
    MenuItem("ارتباط با ما", R.drawable.contact)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    user: User?
) {
    val isExpanded = remember {
        mutableStateOf(false)
    }
    AnimatedVisibility(
        visible = true,
        exit = slideOutVertically() + fadeOut(),
        enter = slideInHorizontally()
    ) {
        TopAppBar(
            title = {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "",
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .clickable {
                                    navController.popBackStack()
                                },
                        )
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = null
                        )
                        Image(
                            modifier = Modifier.padding(top = 12.dp),
                            painter = painterResource(id = R.drawable.online_shop),
                            contentDescription = null
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(user?.image ?: R.drawable.logo),
                            contentDescription = "",
                            modifier = Modifier.size(30.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.notification),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .size(25.dp)
                        )
                        ExposedDropdownMenuBox(
                            expanded = isExpanded.value,
                            onExpandedChange = { isExpanded.value = !isExpanded.value }
                        ) {
                            Box(
                                modifier = Modifier
                                    .menuAnchor() // Required anchor for dropdown
                                    .clickable { isExpanded.value = true }
                            ) {
                                Icon(
                                    if (isExpanded.value) Icons.Default.Close else Icons.Default.Menu,
                                    contentDescription = ""
                                )
                            }
                            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                                ExposedDropdownMenu(
                                    expanded = isExpanded.value,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.White)
                                        .padding(bottom = 100.dp),
                                    onDismissRequest = { isExpanded.value = false }) {
                                    Row(
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .fillMaxWidth()
                                            .background(background)
                                            .padding(vertical = 10.dp, horizontal = 5.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Row(horizontalArrangement = Arrangement.Center) {
                                            Image(
                                                painter = painterResource(user?.image ?: R.drawable.logo),
                                                contentDescription = "",
                                                modifier = Modifier.size(35.dp)
                                            )
                                            Text(
                                                user?.name ?: "",
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                        Text(
                                            user?.phone ?: "09121234567",
                                            fontSize = 10.sp,
                                            modifier = Modifier.padding(end = 10.dp)
                                        )
                                    }
                                    getMenuItems().forEachIndexed { _, txt ->
                                        DropdownMenuItem(
                                            text = {
                                                Row {
                                                    Icon(
                                                        painter = painterResource(txt.image),
                                                        contentDescription = "",
                                                        modifier = Modifier.size(25.dp),
                                                        tint = Color.Unspecified
                                                    )
                                                    Spacer(Modifier.width(10.dp))
                                                    Text(text = txt.name)
                                                }
                                            },
                                            onClick = {
                                                setBottomNavState(-1)
                                                //                                                selectedText.value = listOfMenu[index]
                                                //                                                navController.navigate("${indexToRoute[index]}?index = $index")
                                                isExpanded.value = false
                                            },
                                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                                            colors = MenuDefaults.itemColors(
                                                textColor = Color.Black, // Set the text color
                                            )
                                        )
                                    }
                                }
                            }

                        }
                    }
                }

            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.White
            )
        )
    }
}