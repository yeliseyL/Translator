package com.eliseylobanov.translator.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eliseylobanov.translator.R
import com.eliseylobanov.translator.databinding.FragmentHistoryBinding
import com.eliseylobanov.translator.ui.HistoryAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment(R.layout.fragment_history) {

    private val viewModel: HistoryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHistoryBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        val adapter = HistoryAdapter()

        binding.historyRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.historyRecyclerview.adapter = adapter

        return binding.root
    }

}