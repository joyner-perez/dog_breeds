package com.joyner.dogcatalog.data.sources

import com.joyner.dogcatalog.data.db.AppDatabase
import com.joyner.dogcatalog.data.models.local.DogBreed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(db: AppDatabase) : LocalDataSource {

    private val dogBreedDao = db.dogBreedDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { dogBreedDao.dogBreedCount() <= 0 }

    override suspend fun saveDogBreed(dogBreed: DogBreed): Long =
        withContext(Dispatchers.IO) { dogBreedDao.insert(dogBreed) }

    override suspend fun getDogBreeds(): List<DogBreed> =
        withContext(Dispatchers.IO) {dogBreedDao.getAll() }

    override suspend fun findById(id: Int): DogBreed =
        withContext(Dispatchers.IO) {dogBreedDao.findById(id) }

    override suspend fun update(dogBreed: DogBreed) {
        withContext(Dispatchers.IO) { dogBreedDao.updateDogBreed(dogBreed) }
    }
}