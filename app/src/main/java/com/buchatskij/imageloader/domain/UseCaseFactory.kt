package com.buchatskij.imageloader.domain

import com.buchatskij.imageloader.data.ImagesDataSourceImpl
import com.buchatskij.imageloader.data.ImagesRepositoryImpl

object UseCaseFactory {

    fun getImageDataUseCase(): GetImageDataUseCase = GetImageDataUseCaseImpl(
        ImagesRepositoryImpl(ImagesDataSourceImpl())
    )
}