package com.joyner.dogcatalog.data.models.mappers

import com.joyner.dogcatalog.data.models.local.DogBreed

fun dogBreedsResponsetoDogBreed(breed: String, subBreed: List<String>): DogBreed = DogBreed(
    breed = breed,
    subBreed = subBreed
)