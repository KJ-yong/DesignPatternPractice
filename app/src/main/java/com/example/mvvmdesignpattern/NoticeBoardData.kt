package com.example.mvvmdesignpattern

import java.io.Serializable

data class NoticeBoardData(val title : String, val writer : String, val writingTime : String, val writing : String) :
    Serializable {
}