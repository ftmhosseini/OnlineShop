package com.example.onlineshop.domain.model

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val image: Int,
    val name: String,
    val price: Long,
    val discount: Int = 0,
    val rate: Int = 0,
    val description: String,
    val features: List<Feature> = emptyList(),
    val opinion: List<Opinion> = emptyList(),
    val groupTitle: GroupInfo,
    val subGroup: GroupInfo
):Parcelable

val NavType.Companion.ProductNavType: NavType<Product>
    get() = object : NavType<Product>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Product? {
        // For retrieving from bundle (e.g., if passed directly, though we're using path)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, Product::class.java)
        } else {
            @Suppress("DEPRECATION")
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): Product {
        // This is crucial: parse the JSON string from the URL path back into a Product object
        return Gson().fromJson(value, Product::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Product) {
        // For putting into bundle (not directly used for path args, but good practice)
        bundle.putParcelable(key, value)
    }
}