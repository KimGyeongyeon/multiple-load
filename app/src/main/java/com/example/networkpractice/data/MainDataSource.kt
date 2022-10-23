package com.example.networkpractice.data

import android.graphics.Bitmap

interface MainDataSource {

    interface MainTextCallback{
        fun onTextLoaded(text: String)
        fun onFailed()
    }

    interface MainImageCallback{
        fun onImageLoaded(image: Bitmap)
        fun onFailed()
    }

    fun loadText(callback: MainTextCallback)
    fun loadImage(callback: MainImageCallback)
}