package com.example.mvvmdesignpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.mvvmdesignpattern.databinding.ActivityReadingBinding

class ReadingActivity : AppCompatActivity() {
    lateinit var binding : ActivityReadingBinding
    lateinit var data : NoticeBoardData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reading)
        data = intent.getSerializableExtra("data") as NoticeBoardData
        binding.activity = this@ReadingActivity
    }
    fun backToMainActivity(view : View){
        finish()
    }
}