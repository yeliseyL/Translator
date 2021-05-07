package com.eliseylobanov.historyscreen

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eliseylobanov.translator.model.entities.DataModel

@BindingAdapter("listHistoryData")
fun bindHistoryRecyclerView(recyclerView: RecyclerView, data: List<DataModel>?) {
    val adapter = recyclerView.adapter as HistoryAdapter
    adapter.submitList(data)
}