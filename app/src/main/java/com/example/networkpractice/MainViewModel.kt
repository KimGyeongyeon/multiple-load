package com.example.networkpractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    private val repository = MainRepository()
    private val _text: MutableLiveData<String> by lazy {
        MutableLiveData<String>(repository.loadText())
    }
    val text: LiveData<String> = _text

    fun copyText() {
        val original = text.value
        _text.value = original + original
    }

    fun doTrickydWork() {
        viewModelScope.launch {
            // do somethind
        }
    }

}