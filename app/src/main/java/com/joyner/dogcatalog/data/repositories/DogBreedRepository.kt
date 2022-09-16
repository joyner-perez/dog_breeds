package com.joyner.dogcatalog.data.repositories

import com.joyner.dogcatalog.data.models.local.DogBreed
import com.joyner.dogcatalog.data.models.mappers.dogBreedsResponsetoDogBreed
import com.joyner.dogcatalog.data.sources.LocalDataSource
import com.joyner.dogcatalog.data.sources.RemoteDataSource

class DogBreedRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) {

    suspend fun getDogBreeds(): List<DogBreed> {
        if (localDataSource.isEmpty()) {
            val dogBreeds = remoteDataSource.getDogBreeds()
            localDataSource.saveDogBreed(dogBreedsResponsetoDogBreed("african", dogBreeds.breeds.african))
            localDataSource.saveDogBreed(dogBreedsResponsetoDogBreed("affenpinscher", dogBreeds.breeds.affenpinscher))
            localDataSource.saveDogBreed(dogBreedsResponsetoDogBreed("airedale", dogBreeds.breeds.airedale))
            localDataSource.saveDogBreed(dogBreedsResponsetoDogBreed("akita", dogBreeds.breeds.akita))
            localDataSource.saveDogBreed(dogBreedsResponsetoDogBreed("appenzeller", dogBreeds.breeds.appenzeller))
            localDataSource.saveDogBreed(dogBreedsResponsetoDogBreed("australian", dogBreeds.breeds.australian))
            localDataSource.saveDogBreed(dogBreedsResponsetoDogBreed("basenji", dogBreeds.breeds.basenji))
            localDataSource.saveDogBreed(dogBreedsResponsetoDogBreed("buhund", dogBreeds.breeds.buhund))
            localDataSource.saveDogBreed(dogBreedsResponsetoDogBreed("bulldog", dogBreeds.breeds.bulldog))
            localDataSource.saveDogBreed(dogBreedsResponsetoDogBreed("bullterrier", dogBreeds.breeds.bullterrier))
            localDataSource.saveDogBreed(dogBreedsResponsetoDogBreed("hound", dogBreeds.breeds.hound))
            localDataSource.saveDogBreed(dogBreedsResponsetoDogBreed("terrier", dogBreeds.breeds.terrier))
        }

        return localDataSource.getDogBreeds()
    }
}