package com.eliseylobanov.translator.ui

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eliseylobanov.translator.R
import com.eliseylobanov.translator.model.entities.DataModel
import com.squareup.picasso.Picasso

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<DataModel>?) {
    val adapter = recyclerView.adapter as MainAdapter
    adapter.submitList(data)
}

@BindingAdapter("listHistoryData")
fun bindHistoryRecyclerView(recyclerView: RecyclerView, data: List<DataModel>?) {
    val adapter = recyclerView.adapter as HistoryAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Picasso.with(imgView.context)
                .load(imgUri)
                .placeholder(R.drawable.loading_animation)
                .into(imgView)
    }
}
