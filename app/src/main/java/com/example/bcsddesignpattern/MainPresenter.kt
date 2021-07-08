package com.example.bcsddesignpattern

class MainPresenter(val view : MainContract.View) : MainContract.Presenter {
    override fun readNotice(data: NoticeBoardData) {
        view.changeReadingActivity(data)
    }

    override fun refreshRecycler(adapter: NoticeBoardAdapter) {
        view.showNoticeBoard(adapter)
    }

    override fun writeNotice() {
        view.changeWritingActivity()
    }

    override fun addNoticeData(data : NoticeBoardData) {
        view.addNoticeBoard(data)
    }
}