package com.buchatskij.imageloader.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buchatskij.imageloader.domain.GetImageDataUseCase
import com.buchatskij.imageloader.domain.UseCaseFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val DEFAULT_URL = "http://lorempixel.com/output/people-q-c-640-480-4.jpg"

class MainActivityViewModel(
    private val getImageDataUseCase: GetImageDataUseCase = UseCaseFactory.getImageDataUseCase()
) : ViewModel() {

    enum class UiState {
        PROGRESS, CONTENT
    }

    val imageData: MutableLiveData<ByteArray> = MutableLiveData()
    val url = MutableLiveData(DEFAULT_URL)
    val uiState = MutableLiveData(UiState.CONTENT)

    fun loadImage() {
        uiState.value = UiState.PROGRESS
        viewModelScope.launch {
            val imageUrl = url.value ?: return@launch
            imageData.value = getImageData(imageUrl)
            uiState.value = UiState.CONTENT
        }
    }

    private suspend fun getImageData(imageUrl: String): ByteArray? = withContext(Dispatchers.IO) {
        getImageDataUseCase(imageUrl)
    }
}