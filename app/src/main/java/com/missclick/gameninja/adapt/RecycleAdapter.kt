package com.missclick.gameninja.adapt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.missclick.gameninja.R
import com.missclick.gameninja.data.models.EndModel

class RecycleAdapter(var items: MutableList<EndModel>, val callback: Any) : RecyclerView.Adapter<RecycleAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }
    fun removeAt(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }
    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.text_1)
        private val teacherName = itemView.findViewById<TextView>(R.id.text_2)
        private val type = itemView.findViewById<TextView>(R.id.text_3)
        fun bind(item: EndModel) {
            name.text = item.fails.toString()
            teacherName.text = item.fails.toString()
            type.text = item.fails.toString()
            itemView.setOnClickListener {

            }
        }
    }

    interface Callback {
        fun onItemClicked(item: EndModel)
    }
}