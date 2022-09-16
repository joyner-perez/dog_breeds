package com.joyner.dogcatalog.ui.main

import com.joyner.dogcatalog.data.repositories.DogBreedRepository
import com.joyner.dogcatalog.usecases.GetDogBreeds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class MainActivityModule {

    @Provides
    @ViewModelScoped
    fun getPopularMoviesProvider(dogBreedRepository: DogBreedRepository) =
        GetDogBreeds(dogBreedRepository)
}