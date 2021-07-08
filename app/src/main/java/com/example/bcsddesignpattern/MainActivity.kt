package com.example.bcsddesignpattern


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.bcsddesignpattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {
    val presenter by lazy { MainPresenter(this) }
    lateinit var binding : ActivityMainBinding
    private var adapter = NoticeBoardAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.mainToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.recyclerViewNoticeBoard.adapter = adapter
        presenter.refreshRecycler(adapter)
        adapter.setOnItemClickListner(object : NoticeBoardAdapter.OnitemClickListener{
            override fun onItemClick(view: View, data: NoticeBoardData, position: Int) {
                presenter.readNotice(data)
            }
        })
        binding.addNotice.setOnClickListener{
            presenter.writeNotice()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.refreshRecycler(adapter)
    }

    override fun onRestart() {
        super.onRestart()
        presenter.refreshRecycler(adapter)
    }

    override fun showNoticeBoard(adapter: NoticeBoardAdapter) {
        adapter.notifyDataSetChanged()
    }

    override fun addNoticeBoard(data : NoticeBoardData) {
        adapter.additem(data)
    }

    override fun changeWritingActivity() {
        startActivityForResult(Intent(this,WritingActivity::class.java),0)
    }

    override fun changeReadingActivity(data: NoticeBoardData) {
        intent = Intent(this, ReadingActivity::class.java)
        intent.putExtra("data", data)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==0&&resultCode== RESULT_OK){
            val noticeData = data?.getSerializableExtra("addData") as NoticeBoardData?
            if (noticeData != null) {
                presenter.addNoticeData(noticeData)
            }
            presenter.refreshRecycler(adapter)
        }
    }
}