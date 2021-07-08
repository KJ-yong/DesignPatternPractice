package com.example.bcsddesignpattern

interface ReadingContract {
    interface View{
        fun showWriting()
        fun changeMainActivity()
    }
    interface Presenter{
        fun showNotice()
        fun backToMain()
    }
}