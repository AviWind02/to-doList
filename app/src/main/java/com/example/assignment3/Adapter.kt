package com.example.assignment3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class Adapter(private val dataSet: MutableList<listData>):
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
       val itemTitle: TextView
       val itemBody: TextView
        val isDone: Switch
        init {
            // Define click listener for the ViewHolder's View.
            itemTitle = view.findViewById(R.id.item_title)
            itemBody = view.findViewById(R.id.item_description)
            isDone = view.findViewById(R.id.is_task_done)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemTitle.text = dataSet[position].listTitle
        viewHolder.itemBody.text = dataSet[position].listDescription
        viewHolder.isDone.isActivated = dataSet[position].done
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}