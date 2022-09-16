package com.pollenweather.data.db.daos

import androidx.room.*
import com.joyner.dogcatalog.data.models.local.DogBreed

@Dao
interface DogBreedDao {

    @Query("SELECT * FROM dog_breeds")
    suspend fun getAll(): List<DogBreed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dogBreed: DogBreed): Long

    @Update
    suspend fun updateDogBreed(vararg dogBreed: DogBreed)

    @Delete
    suspend fun delete(dogBreed: DogBreed): Int

    @Query("SELECT COUNT(id) FROM dog_breeds")
    fun dogBreedCount(): Int

    @Query("SELECT * FROM dog_breeds WHERE id = :id")
    fun findById(id: Int): DogBreed
}