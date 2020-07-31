package com.mansi.twattle

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.mansi.twattle.model.Student

class MainRecyclerAdapter(val context: Context, val itemList:ArrayList<Student>):RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtSubName: TextView = view.findViewById(R.id.txtSubName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_main_single_row, parent, false)
        return MainViewHolder(view)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val student = itemList[position]
        holder.txtSubName.text = student.SubName
        holder.txtSubName.setOnClickListener {
            val intent = Intent(context, DisplayDetails::class.java).apply {
            putExtra("SubName", student.SubName)
        }
            context.startActivity(intent)
        }

    }
}