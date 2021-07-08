package com.example.bcsddesignpattern

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WritingPresenter(val view : WritingContract.View) : WritingContract.Presenter {
    override fun cancelWriting() {
        view.backToMainActivity()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun saveNotice(title: String, writer: String, writing: String) {
        if(title.isBlank()||writer.isBlank()||writing.isBlank()) view.showToast()
        else view.goToMainActivity(NoticeBoardData(title,writer,LocalDateTime.now().format(DateTimeFormatter.ofPattern("h:mm")).toString(),writing))
    }
}