package com.example.bcsddesignpattern

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.bcsddesignpattern.databinding.ActivityWritingBinding

class WritingActivity : AppCompatActivity(), WritingContract.View {
    lateinit var binding : ActivityWritingBinding
    val presenter by lazy { WritingPresenter(this) }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_writing)
        binding.cancelButton.setOnClickListener {
            presenter.cancelWriting()
        }
        binding.saveButton.setOnClickListener {
            presenter.saveNotice(binding.titleText.text.toString(),binding.writerText.text.toString(),binding.writingText.text.toString())
        }
    }

    override fun backToMainActivity() {
        finish()
    }

    override fun goToMainActivity(data: NoticeBoardData) {
        intent = Intent(this, MainActivity::class.java)
        intent.putExtra("addData",data)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }

    override fun showToast() {
        Toast.makeText(this,"빈 칸을 채워주세요",Toast.LENGTH_LONG).show()
    }
}