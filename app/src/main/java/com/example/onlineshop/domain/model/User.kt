package com.example.onlineshop.domain.model

import kotlinx.coroutines.flow.MutableStateFlow

data class User(
    val name:String,
    val phone:String,
    val email: String = "",
    val image:Int,
)
