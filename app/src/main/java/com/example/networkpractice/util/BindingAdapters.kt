package com.example.networkpractice.util

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("bind:imageBitmap")
    fun setBitmapSrc(iv: ImageView, bitmap: Bitmap?) {
        // url을 받아서 여기서 글라이드를 호출해도 된다고 함
        iv.setImageBitmap(bitmap)
    }
}