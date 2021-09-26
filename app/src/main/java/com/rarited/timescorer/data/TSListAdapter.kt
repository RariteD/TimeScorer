package com.rarited.timescorer.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rarited.timescorer.R
import com.rarited.timescorer.data.TSListAdapter.TimerViewHolder

class TSListAdapter : ListAdapter<TSDataEntity, TimerViewHolder>(TIMERS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimerViewHolder {
        return TimerViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TimerViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.tsName)
    }

    class TimerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val timerItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            timerItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): TimerViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return TimerViewHolder(view)
            }
        }
    }

    companion object {
        private val TIMERS_COMPARATOR = object : DiffUtil.ItemCallback<TSDataEntity>() {
            override fun areItemsTheSame(oldItem: TSDataEntity, newItem: TSDataEntity): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: TSDataEntity, newItem: TSDataEntity): Boolean {
                return oldItem.tsName == newItem.tsName
            }
        }
    }
}