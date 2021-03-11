package com.lowes.weathertest

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.lowes.weathertest.model.Response


class MyResponseRecyclerViewAdapter(
    private val values: List<Response>,
    private val rowClick:onRowClickListener
) : RecyclerView.Adapter<MyResponseRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = "Temp: ${item.main.temp}"
        holder.contentView.text = "${item.weather.get(0).main}"
        holder.itemView.setOnClickListener({
            rowClick.onItemClick(item)
        })
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

    interface onRowClickListener{
        fun onItemClick(response:Response)
    }
}