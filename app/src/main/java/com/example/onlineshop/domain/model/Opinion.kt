package com.example.onlineshop.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Opinion(
    val name: String,
    val rate: Double = 0.0,
    val opinion: String,
    val hasAnswered: List<Opinion> = listOf()
):Parcelable
