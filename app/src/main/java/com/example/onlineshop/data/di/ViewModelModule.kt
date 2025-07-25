package com.example.onlineshop.data.di

import com.example.onlineshop.domain.repository.Repository
import com.example.onlineshop.data.room.BasketDao
import com.example.onlineshop.presentation.ui.viewmodel.BasketViewModel
import com.example.onlineshop.presentation.ui.viewmodel.ShopViewModel
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Singleton
    @ViewModelScoped
     fun provideShopViewModel(
         repository: Repository
     ): ShopViewModel {
         return ShopViewModel(repository)
     }

    @Singleton
    @ViewModelScoped
     fun provideRoomViewModel(
         dao: BasketDao
     ): BasketViewModel {
         return BasketViewModel(dao)
     }
}