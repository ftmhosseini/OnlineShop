package com.example.onlineshop.domain.model

data class Address(
    val destinationName: String,
    val destinationAddress: String,
    val zipCode: String,
    val phone: String,
    val isSelected: Boolean = false
)
