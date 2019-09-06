package com.buchatskij.imageloader.domain

interface ImagesRepository {

    fun getImagesData(imageUrl: String): ByteArray?
}
