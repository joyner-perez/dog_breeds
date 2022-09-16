package com.joyner.dogcatalog.data.server

import com.joyner.dogcatalog.data.models.remote.DogBreedsResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogBreedsApi {

    @GET("list/all")
    suspend fun getDogBreedsApi() : Response<DogBreedsResponse>
}