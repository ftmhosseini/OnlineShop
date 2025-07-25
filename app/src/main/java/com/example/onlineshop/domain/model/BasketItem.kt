package com.example.onlineshop.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "basket")
data class BasketItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val productName: String,
    val price: Long,
    val discount: Int,
    val quantity: Int,
    val imageRes: Int // drawable resource ID
)
