package com.joyner.dogcatalog.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joyner.dogcatalog.data.models.local.DogBreed
import com.pollenweather.data.db.daos.DogBreedDao

@Database(entities = [DogBreed::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dogBreedDao(): DogBreedDao
}
