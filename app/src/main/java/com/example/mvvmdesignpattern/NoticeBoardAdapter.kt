package com.example.mvvmdesignpattern

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdesignpattern.databinding.NoticeboardRecyclerBinding

class NoticeBoardAdapter(private val context: Context) : RecyclerView.Adapter<NoticeBoardAdapter.ViewHolder>() {
    var datas = mutableListOf<NoticeBoardData>()
    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder {
        val binding = NoticeboardRecyclerBinding.inflate(
                LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }
    interface OnitemClickListener{
        fun onItemClick(view : View, data : NoticeBoardData, position : Int)
    }
    private var listener : OnitemClickListener?=null
    fun setOnItemClickListner(listener : OnitemClickListener){
        this.listener = listener
    }

    override fun getItemCount(): Int = datas.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }
    fun setData(dataList : ArrayList<NoticeBoardData>){
        datas = dataList
        notifyDataSetChanged()
    }
    inner class ViewHolder(val binding : NoticeboardRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : NoticeBoardData){
            binding.noticeData =item
            val position = adapterPosition
            if(position!= RecyclerView.NO_POSITION){
                itemView.setOnClickListener{
                    listener?.onItemClick(itemView, item, position)
                }
            }
        }
    }
}