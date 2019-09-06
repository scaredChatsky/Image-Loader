package com.buchatskij.imageloader.domain

interface GetImageDataUseCase {

    operator fun invoke(imageUrl: String): ByteArray?
}

class GetImageDataUseCaseImpl(private val imagesRepository: ImagesRepository) : GetImageDataUseCase {

    override fun invoke(imageUrl: String): ByteArray? =
        imagesRepository.getImagesData(imageUrl)
}