package com.example.onlineshop.domain.repository

import com.example.onlineshop.domain.model.Address
import com.example.onlineshop.domain.model.Banner
import com.example.onlineshop.domain.model.Product
import com.example.onlineshop.domain.model.User
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getBannerData(): Flow<List<Banner>>
    suspend fun getProducts(): Flow<List<Product>>
    suspend fun getProduct(index:Int): Product
    suspend fun getAddresses(): Flow<List<Address>>
    suspend fun getUser(): User
}