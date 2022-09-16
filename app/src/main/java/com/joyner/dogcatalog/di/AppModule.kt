package com.joyner.dogcatalog.di

import android.app.Application
import androidx.room.Room
import com.joyner.dogcatalog.data.db.AppDatabase
import com.joyner.dogcatalog.data.server.DogBreedsDataSource
import com.joyner.dogcatalog.data.sources.LocalDataSource
import com.joyner.dogcatalog.data.sources.RemoteDataSource
import com.joyner.dogcatalog.data.sources.RoomDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        AppDatabase::class.java, "dog-breeds-db"
    ).build()

    @Provides
    fun localDataSourceProvider(db: AppDatabase): LocalDataSource = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(): RemoteDataSource = DogBreedsDataSource()
}