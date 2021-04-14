package com.eliseylobanov.translator.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eliseylobanov.translator.databinding.FragmentMainRecyclerviewItemBinding
import com.eliseylobanov.translator.model.entities.DataModel

class MainAdapter(private val onClickListener: OnClickListener) :
        ListAdapter<DataModel, MainAdapter.RecyclerItemViewHolder>(DiffCallback) {

    class RecyclerItemViewHolder(private var binding: FragmentMainRecyclerviewItemBinding) :
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
        return RecyclerItemViewHolder(FragmentMainRecyclerviewItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        val data = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(data)
        }
        holder.bind(data)
    }

    class OnClickListener(val clickListener: (data: DataModel) -> Unit) {
        fun onClick(data: DataModel) = clickListener(data)
    }
}