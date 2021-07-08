package com.example.bcsddesignpattern

interface WritingContract {
    interface View{
        fun backToMainActivity()
        fun goToMainActivity(data : NoticeBoardData)
        fun showToast()
    }
    interface Presenter{
        fun cancelWriting()
        fun saveNotice(title : String, writer : String, writing : String)
    }
}