package com.example.onlineshop.data.di

import android.content.Context
import androidx.room.Room
import com.example.onlineshop.data.room.AppDatabase
import com.example.onlineshop.data.room.BasketDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "online_shop_database"
        ).build()
    }

    @Provides
    fun provideBasketDao(db: AppDatabase): BasketDao = db.basketDao()
}