package com.example.bcsddesignpattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bcsddesignpattern.databinding.ActivityReadingBinding

class ReadingActivity : AppCompatActivity(), ReadingContract.View{
    lateinit var binding : ActivityReadingBinding
    val presenter by lazy { ReadingPresenter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reading)
        presenter.showNotice()
        binding.backButton.setOnClickListener {
            presenter.backToMain()
        }
    }

    override fun showWriting() {
        val data = intent.getSerializableExtra("data") as NoticeBoardData
        binding.titleText.text = data.title
        binding.writerText.text = data.writer
        binding.writingText.text = data.writing
    }

    override fun changeMainActivity() {
        finish()
    }
}