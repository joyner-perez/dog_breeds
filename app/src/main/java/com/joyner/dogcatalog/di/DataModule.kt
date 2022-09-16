package com.joyner.dogcatalog.di

import com.joyner.dogcatalog.data.repositories.DogBreedRepository
import com.joyner.dogcatalog.data.sources.LocalDataSource
import com.joyner.dogcatalog.data.sources.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun dogBreedsRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) = DogBreedRepository(localDataSource, remoteDataSource)
}