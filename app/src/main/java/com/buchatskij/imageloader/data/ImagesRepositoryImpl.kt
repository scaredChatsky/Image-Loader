package com.buchatskij.imageloader.data

import com.buchatskij.imageloader.domain.ImagesRepository

class ImagesRepositoryImpl(private val imagesDataSource: ImagesDataSource) : ImagesRepository {

    override fun getImagesData(imageUrl: String): ByteArray? =
        imagesDataSource.getImagesData(imageUrl)
}