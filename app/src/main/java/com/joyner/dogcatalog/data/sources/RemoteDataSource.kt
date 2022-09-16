package com.joyner.dogcatalog.data.sources

import com.joyner.dogcatalog.data.models.remote.DogBreedsResponse

interface RemoteDataSource {
    suspend fun getDogBreeds(): DogBreedsResponse
}