package com.eliseylobanov.translator.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eliseylobanov.translator.model.entities.DataModel

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<DataModel>?) {
    val adapter = recyclerView.adapter as MainAdapter
    adapter.submitList(data)
}
