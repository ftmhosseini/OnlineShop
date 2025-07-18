package com.example.onlineshop.data

data class Address(
    val destinationName: String,
    val destinationAddress: String,
    val zipCode: String,
    val phone: String,
    val isSelected: Boolean = false
)
