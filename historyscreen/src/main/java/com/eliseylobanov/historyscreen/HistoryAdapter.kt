package com.eliseylobanov.historyscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eliseylobanov.historyscreen.databinding.FragmentHistoryItemBinding
import com.eliseylobanov.translator.model.entities.DataModel


class HistoryAdapter :
        ListAdapter<DataModel, HistoryAdapter.RecyclerItemViewHolder>(DiffCallback) {

    class RecyclerItemViewHolder(private var binding: FragmentHistoryItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataModel) {
            binding.data = data
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DataModel>() {
        override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
            return oldItem.text == newItem.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerItemViewHolder {
        return RecyclerItemViewHolder(FragmentHistoryItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }
}