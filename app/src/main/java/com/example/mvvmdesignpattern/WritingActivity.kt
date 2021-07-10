package com.example.mvvmdesignpattern

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdesignpattern.databinding.ActivityWritingBinding

class WritingActivity : AppCompatActivity() {
    lateinit var binding : ActivityWritingBinding
    lateinit var viewModel : WritingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_writing)
        binding.activity = this@WritingActivity
        viewModel = ViewModelProvider(this).get(WritingViewModel::class.java)
        //binding.cancelButton.setOnClickListener { backToMainActivity() }
    }

    fun backToMainActivity(view : View){
        finish()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun saveWriting(view : View){
        if(viewModel.checkBlank(binding.titleText.text.toString(),binding.writerText.text.toString(),binding.writerText.text.toString())){
            Toast.makeText(this,"빈 칸을 채워주세요", Toast.LENGTH_LONG).show()
        }
        else {
            intent = Intent(this, MainActivity::class.java)
            intent.putExtra("addData",viewModel.getData(binding.titleText.text.toString(),binding.writerText.text.toString(),binding.writerText.text.toString()))
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}