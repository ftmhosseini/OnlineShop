package com.example.onlineshop.data

import android.provider.ContactsContract.CommonDataKinds.Email

data class User(
    val name:String,
    val phone:String,
    val email: String = "",
    val image:Int,
)
