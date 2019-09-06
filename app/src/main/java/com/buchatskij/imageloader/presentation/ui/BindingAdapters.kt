package com.buchatskij.imageloader.presentation.ui

import android.graphics.BitmapFactory
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageData")
fun setImageUrl(imageView: ImageView, imageData: ByteArray?) {
    imageData?.let {
        val bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.size)
        imageView.setImageBitmap(bitmap)
    }
}