package com.example.networkpractice.data

import com.example.networkpractice.data.remote.RemoteDataSource

class MainRepository(
    private val remoteDataSource: RemoteDataSource,
) : MainDataSource {

    override fun loadText(callback: MainDataSource.MainTextCallback) {
        // 원래는 interface 상속받아서 구현하는게 확장에 유리함
        remoteDataSource.loadText(callback)
    }

    override fun loadImage(callback: MainDataSource.MainImageCallback) {
        remoteDataSource.loadImage(callback)
    }

    companion object {
        private const val NO_INTERNET = "No Internet "
    }
}