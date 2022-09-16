package com.joyner.dogcatalog.usecases

import com.joyner.dogcatalog.data.models.local.DogBreed
import com.joyner.dogcatalog.data.repositories.DogBreedRepository

class GetDogBreeds(private val dogBreedRepository: DogBreedRepository) {
    suspend fun invoke(): List<DogBreed> = dogBreedRepository.getDogBreeds()
}