package com.buchatskij.imageloader.data

import java.net.URL

interface ImagesDataSource {

    fun getImagesData(imageUrl: String): ByteArray?
}

class ImagesDataSourceImpl : ImagesDataSource {

    override fun getImagesData(imageUrl: String): ByteArray? {
        return try {
            val url = URL(imageUrl)
            val inputStream = url.openConnection().getInputStream()
            inputStream.readBytes()
        } catch (e: Exception) {
            null
        }
    }
}