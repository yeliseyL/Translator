package com.eliseylobanov.translator.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eliseylobanov.translator.R
import com.eliseylobanov.translator.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_details) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val word = DetailsFragmentArgs.fromBundle(requireArguments()).word
        binding.word = word
        return binding.root
    }


}