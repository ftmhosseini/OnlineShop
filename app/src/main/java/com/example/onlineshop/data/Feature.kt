package com.example.onlineshop.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Feature(
    val type: String,
    val value: String
):Parcelable
