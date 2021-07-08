package com.example.bcsddesignpattern




interface MainContract {
    interface View{
        fun showNoticeBoard(adapter: NoticeBoardAdapter)
        fun addNoticeBoard(data : NoticeBoardData)
        fun changeWritingActivity()
        fun changeReadingActivity(data : NoticeBoardData)
    }
    interface Presenter{
        fun refreshRecycler(adapter: NoticeBoardAdapter)
        fun readNotice(data : NoticeBoardData)
        fun writeNotice()
        fun addNoticeData(data : NoticeBoardData)
    }
}