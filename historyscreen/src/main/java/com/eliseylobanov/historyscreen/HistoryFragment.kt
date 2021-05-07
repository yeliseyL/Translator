package com.eliseylobanov.historyscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eliseylobanov.historyscreen.databinding.FragmentHistoryBinding
import org.koin.android.scope.currentScope

class HistoryFragment : Fragment(R.layout.fragment_history) {

    private val viewModel: HistoryViewModel by lazy { requireActivity().currentScope.get() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHistoryBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        injectDependencies()

        val adapter = HistoryAdapter()

        binding.historyRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.historyRecyclerview.adapter = adapter

        return binding.root
    }

}