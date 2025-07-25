package com.example.onlineshop.domain.model

import com.example.onlineshop.R
import kotlinx.serialization.Serializable

@Serializable
enum class GroupInfo(val title: String, val image: Int) {
    Woman("زنانه", R.drawable.woman),
    Man("مردانه", R.drawable.man),
    Girl("دخترانه", R.drawable.girls),
    Boy("پسرانه", R.drawable.boys),
    Baby("نوزادی", R.drawable.baby),
    Shoes("کفش", R.drawable.shoes),
    Shirt("بلوز و پیراهن", R.drawable.man1),
    TShirt("تیشرت و پولیور", R.drawable.shirt),
    Casual("راحتی", R.drawable.casual),
    Pants("شلوار و شلوارک", R.drawable.pants),
    Socks("جوراب", R.drawable.socks),
    Bag("کیف", R.drawable.bag)
}


//sealed class GroupInfo(
//    val name: String,
//    val image: Int
//) {
//    data object Woman : GroupInfo("زنانه", R.drawable.woman)
//    data object Man : GroupInfo("مردانه", R.drawable.man)
//    data object Girl : GroupInfo("دخترانه", R.drawable.girls)
//    data object Boy : GroupInfo("پسرانه", R.drawable.boys)
//    data object Baby : GroupInfo("نوزادی", R.drawable.baby)
//    data object Shoes : GroupInfo("کفش", R.drawable.shoes)
//
//    data object Shirt : GroupInfo(name = "بلوز و پیراهن", R.drawable.man1)
//    data object TShirt : GroupInfo(name = "تیشرت و پولیور", R.drawable.shirt)
//    data object Casual : GroupInfo(name = "راحتی", R.drawable.casual)
//    data object Pants : GroupInfo(name = "شلوار و شلوارک", R.drawable.pants)
//    data object Socks : GroupInfo(name = "جوراب", R.drawable.socks)
//    data object Bag : GroupInfo(name = "کیف", R.drawable.bag)
//}

val topLevelGroup = listOf(
    GroupInfo.Woman,
    GroupInfo.Man,
    GroupInfo.Girl,
    GroupInfo.Boy,
    GroupInfo.Baby,
    GroupInfo.Shoes,
)

val secondLevelGroup = listOf(
    GroupInfo.Shirt,
    GroupInfo.TShirt,
    GroupInfo.Casual,
    GroupInfo.Pants,
    GroupInfo.Socks,
    GroupInfo.Bag
)
