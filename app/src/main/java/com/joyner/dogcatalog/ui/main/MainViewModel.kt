package com.joyner.dogcatalog.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.joyner.dogcatalog.data.models.local.DogBreed
import com.joyner.dogcatalog.ui.common.ScopedViewModel
import com.joyner.dogcatalog.usecases.GetDogBreeds
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getDogBreeds: GetDogBreeds) : ScopedViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val dogBreedList: List<DogBreed>) : UiModel()
        class Navigation(val dogBreed: DogBreed) : UiModel()
    }

    init {
        initScope()
        launch {
            _model.value = UiModel.Loading
            _model.value = UiModel.Content(getDogBreeds.invoke())
        }
    }

    private fun refresh() {

    }

    fun onDogBreedClicked(dogBreed: DogBreed) {
        _model.value = UiModel.Navigation(dogBreed)
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}