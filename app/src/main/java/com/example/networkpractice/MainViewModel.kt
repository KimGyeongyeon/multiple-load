package com.example.networkpractice

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkpractice.data.MainDataSource
import com.example.networkpractice.data.MainRepository
import com.example.networkpractice.data.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    private val repository = MainRepository(
        RemoteDataSource()
    )

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    private val _image = MutableLiveData<Bitmap>()
    val image: LiveData<Bitmap> = _image

    init {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("K001 ViewModel", "start")

            repository.loadText(object : MainDataSource.MainTextCallback {
                override fun onTextLoaded(text: String) {
                    this@launch.launch(Dispatchers.Main) {
                        _text.value = text
                    }
                }

                override fun onFailed() {
                    this@launch.launch(Dispatchers.Main) {
                        _text.value = "잘 보이는 글자 "
                    }
                }
            })

            repository.loadImage(object : MainDataSource.MainImageCallback {
                override fun onImageLoaded(image: Bitmap) {
                    this@launch.launch(Dispatchers.Main) {
                        _image.value = image
                    }
                }

                override fun onFailed() {
                    Log.d("K001 ViewModel", "Image load fail")
                }
            })
        }
    }

    fun copyText() {
        val original = text.value
        _text.value = original + original
    }

    // viewModelScope는 라이프 사이클이 종료될 때 함께 정리된다.
}