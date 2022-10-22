package com.example.networkpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.networkpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val model: MainViewModel by viewModels() // default factory로 뷰모델을 생성해준다.
        binding.model = model
        binding.lifecycleOwner = this // 생략시 업데이트 안됨

        binding.duplicateButton.setOnClickListener {
            model.copyText() // 만약 mvvm이라면 이 흐름을 추천하지는 않으셨음
        }
    }
}