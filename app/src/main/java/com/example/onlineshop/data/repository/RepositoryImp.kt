package com.example.onlineshop.data.repository

import com.example.onlineshop.data.remote.ServiceApi
import com.example.onlineshop.domain.model.Address
import com.example.onlineshop.domain.model.Banner
import com.example.onlineshop.domain.model.Product
import com.example.onlineshop.domain.model.User
import com.example.onlineshop.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImp: Repository {
    override suspend fun getBannerData(): Flow<List<Banner>> {
        return flow {
            getBannerData()
        }
    }

    override suspend fun getProducts(): Flow<List<Product>> {
        return flow {
            ServiceApi.productList
        }
    }

    override suspend fun getProduct(index: Int): Product {
        return ServiceApi.productList[index]
    }

    override suspend fun getAddresses(): Flow<List<Address>> {
        return flow {
            ServiceApi.addresses
        }
    }

    override suspend fun getUser(): User {
        return ServiceApi.user
    }
}