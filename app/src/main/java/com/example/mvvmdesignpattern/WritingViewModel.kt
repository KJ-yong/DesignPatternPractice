package com.example.mvvmdesignpattern

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WritingViewModel : ViewModel() {

    fun checkBlank(title : String, writer : String, writing : String) : Boolean{
        return title.isBlank()||writer.isBlank()||writing.isBlank()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getData(title : String, writer : String, writing : String) : NoticeBoardData {
        return NoticeBoardData(title, writer, LocalDateTime.now().format(DateTimeFormatter.ofPattern("h:mm")).toString(), writing)
    }
}