package com.example.getage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProgrammerAdapter(context: Context, var items:
List<Programmer>) : RecyclerView.Adapter<ProgrammerAdapter.ProgrammerViewHolder>(){
    class ProgrammerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tv_Name: TextView
        var tv_Title: TextView

        init {
            tv_Name= view.findViewById(R.id.tv_Name)
            tv_Title = view.findViewById(R.id.tv_Title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.programmer_adapter_layout, parent, false)

        return ProgrammerViewHolder(view)

    }

    override fun onBindViewHolder(holder: ProgrammerViewHolder, position: Int) {
        holder.tv_Name.text = items[position].name
        holder.tv_Title.text = items[position].title
    }
    override fun getItemCount(): Int {
        return items.size
    }
}

