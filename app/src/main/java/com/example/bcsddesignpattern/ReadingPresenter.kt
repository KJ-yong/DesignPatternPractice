package com.example.bcsddesignpattern

class ReadingPresenter(val view : ReadingContract.View) : ReadingContract.Presenter {
    override fun showNotice() {
        view.showWriting()
    }

    override fun backToMain() {
        view.changeMainActivity()
    }
}