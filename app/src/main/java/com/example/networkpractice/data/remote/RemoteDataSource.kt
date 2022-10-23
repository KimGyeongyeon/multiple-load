package com.example.networkpractice.data.remote

import android.graphics.BitmapFactory
import com.example.networkpractice.data.MainDataSource
import okhttp3.Request

class RemoteDataSource : MainDataSource {

    override fun loadText(callback: MainDataSource.MainTextCallback) {
        val request = Request.Builder()
            .url(TEXT_URL).build()
        InternetClient.client.newCall(request).execute().use {
            if (!it.isSuccessful) {
                callback.onFailed()
            } else {
                callback.onTextLoaded(it.body!!.string())
            }
        }
    }

    override fun loadImage(callback: MainDataSource.MainImageCallback) {
        // 방식1. 사진 하나에 4분 20초 걸림
        val `in` = java.net.URL(IMAGE_URL).openStream()
        val image = BitmapFactory.decodeStream(`in`)
        if (image != null) {
            callback.onImageLoaded(image)
        } else {
            callback.onFailed()
        }
    }

    companion object {
        private const val TEXT_URL = "http://x.ebadaq.com/api/detail?hash=HF778"
        private const val IMAGE_URL =
            "https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F4aa5514e-77d0-4258-a688-0488052ea104%2FCat_square.jpg?table=block&id=9afb01a2-fb51-4eb2-9ec8-d531b3ad1913&spaceId=9b5dd974-fd87-43e6-b0dc-7d68daed2d23&width=1920&userId=7f91c924-4d48-41c4-82c9-b7d968ec5b88&cache=v2"
    }
}