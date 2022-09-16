package com.joyner.dogcatalog.data.server

import com.joyner.dogcatalog.data.models.remote.DogBreedsResponse
import com.joyner.dogcatalog.data.sources.RemoteDataSource

class DogBreedsDataSource : RemoteDataSource {

    override suspend fun getDogBreeds(): DogBreedsResponse =
        RetrofitHelper.getInstance().create(DogBreedsApi::class.java).getDogBreedsApi().body()!!
}