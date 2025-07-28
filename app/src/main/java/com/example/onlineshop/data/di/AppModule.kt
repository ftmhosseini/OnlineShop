package com.example.onlineshop.data.di

import com.example.onlineshop.domain.repository.Repository
import com.example.onlineshop.data.repository.RepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module

@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(): Repository {
        return RepositoryImp()
    }

}