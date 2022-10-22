package com.example.networkpractice

class MainRepository {

    fun loadText(): String {
        // 원래는 interface 상속받아서 구현하는게 확장에 유리함
        return NO_INTERNET
    }

    companion object {
        private const val NO_INTERNET = "No Internet "
    }
}