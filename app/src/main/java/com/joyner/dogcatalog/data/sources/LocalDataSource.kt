package com.joyner.dogcatalog.data.sources

import com.joyner.dogcatalog.data.models.local.DogBreed

interface LocalDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveDogBreed(dogBreed: DogBreed): Long
    suspend fun getDogBreeds(): List<DogBreed>
    suspend fun findById(id: Int): DogBreed
    suspend fun update(dogBreed: DogBreed)
}