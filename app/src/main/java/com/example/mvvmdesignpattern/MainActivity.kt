package com.example.mvvmdesignpattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdesignpattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel
    private var adapter = NoticeBoardAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.recyclerViewNoticeBoard.adapter = adapter
        binding.mainActivity = this@MainActivity
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.dataList.observe(this, Observer { adapter.setData(it) })
        adapter.setOnItemClickListner(object : NoticeBoardAdapter.OnitemClickListener{
            override fun onItemClick(view: View, data: NoticeBoardData, position: Int) {
                changeActivityReading(data)
            }
        })
    }
    fun changeActivityWriting(view : View){
        startActivityForResult(Intent(this,WritingActivity::class.java),0)
    }
    fun changeActivityReading(data : NoticeBoardData){
        intent = Intent(this, ReadingActivity::class.java)
        intent.putExtra("data", data)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val noticeData = data?.getSerializableExtra("addData") as NoticeBoardData?
        if (noticeData != null){
            viewModel.itemAdd(noticeData)
        }
    }
}