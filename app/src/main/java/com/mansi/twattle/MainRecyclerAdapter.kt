package com.mansi.twattle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerAdapter(val context: Context, val itemList:ArrayList<String>):RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {

    class MainViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textView:TextView= view.findViewById(R.id.txtSubName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycler_main_single_row,parent,false)
        return MainViewHolder(view)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val text=itemList[position]
        holder.textView.text=text
    }

}