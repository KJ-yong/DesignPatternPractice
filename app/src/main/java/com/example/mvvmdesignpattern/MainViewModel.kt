package com.example.mvvmdesignpattern


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _dataList = MutableLiveData<ArrayList<NoticeBoardData>>()
    val dataList : LiveData<ArrayList<NoticeBoardData>>
    get() =_dataList
    private var items = ArrayList<NoticeBoardData>()
    init{
        _dataList.value = items
    }
    fun itemAdd(data : NoticeBoardData){
        items.add(data)
        _dataList.value = items
    }
}