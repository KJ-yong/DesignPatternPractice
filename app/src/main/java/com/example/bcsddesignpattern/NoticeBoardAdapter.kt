package com.example.bcsddesignpattern

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoticeBoardAdapter(private val context: Context) : RecyclerView.Adapter<NoticeBoardAdapter.ViewHolder>() {
    var datas = mutableListOf<NoticeBoardData>()
    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.noticeboard_recycler,parent,false))
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
    fun additem(data : NoticeBoardData){
        datas.add(data)
        notifyDataSetChanged()
    }
    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private var title : TextView = itemView.findViewById(R.id.title)
        private var writer : TextView = itemView.findViewById(R.id.writer)
        private var writingTime : TextView = itemView.findViewById(R.id.writingTime)
        fun bind(item : NoticeBoardData){
            title.text = item.title
            writer.text = item.writer
            writingTime.text = item.writingTime
            val position = adapterPosition
            if(position!=RecyclerView.NO_POSITION){
                itemView.setOnClickListener{
                    listener?.onItemClick(itemView, item, position)
                }
            }
        }
    }
}