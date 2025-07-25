package com.example.onlineshop.presentation.ui.bar

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onlineshop.R
import com.example.onlineshop.domain.model.NavItemState
import com.example.onlineshop.presentation.ui.screen.Screen

object GroupLevel {
    var value = mutableIntStateOf(-1) //0 is supergroup, 1 is subgroup, 2 is product
}

fun setLevel(index: Int) {
    GroupLevel.value.intValue = index
}

object BottomNavState {
    var value = mutableIntStateOf(3)
}

fun setBottomNavState(index: Int) {
    setLevel(-1)
    BottomNavState.value.intValue = index
}

fun getScreenRoute(bottomIndex: Int): String {
    val index = -1
    val level = -1
    return when (bottomIndex) {
        0 -> Screen.ProfileScreen.route
        1 -> Screen.BasketScreen.route
        2 -> "${Screen.CategoryScreen.route}/$level/$index"
        3 -> Screen.HomeScreen.route
        else -> Screen.HomeScreen.route // default case
    }
}

@Composable
fun getBottomItems(): List<NavItemState> {
    return listOf(
        NavItemState(
            title = "پروفایل من",
            selectedIcon = R.drawable.user_profile,
        ),
        NavItemState(
            title = "سبد خرید",
            selectedIcon = (R.drawable.shopping_bag),
        ),
        NavItemState(
            title = "دسته بندی",
            selectedIcon = (R.drawable.category),
        ),
        NavItemState(
            title = "خانه",
            selectedIcon = (R.drawable.home),
        ),
    )
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    bottomItems: List<NavItemState>,
    bottomNavState: MutableIntState,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(
        contentColor = Color.White,
        containerColor = Color.White
    ) {
        bottomItems.forEachIndexed { index, navItemState ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.run {
                    colors(
                        selectedIconColor = Color.Unspecified,
                        selectedTextColor = Color.Red,
                        indicatorColor = Color.White,
                        unselectedIconColor = Color.Unspecified,
                        unselectedTextColor = Color.Unspecified,
                    )
                },
                icon = {
                    Icon(
                        modifier = modifier
                            .size(40.dp),
                        painter = painterResource(navItemState.selectedIcon),
                        contentDescription = navItemState.title,
                        tint = Color.Unspecified
                    )
                },
                label = {
                    Text(
                        text = navItemState.title,
                        color = if (bottomNavState.intValue == index) Color.Red else Color.Unspecified
                    )
                },
                selected = bottomNavState.intValue == index,
                onClick = { onItemSelected(index) }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}