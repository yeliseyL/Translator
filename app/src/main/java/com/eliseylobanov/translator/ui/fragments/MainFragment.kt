package com.eliseylobanov.translator.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.eliseylobanov.translator.R
import com.eliseylobanov.translator.databinding.FragmentMainBinding
import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.presenter.MainPresenter
import com.eliseylobanov.translator.presenter.MainPresenterImpl
import com.eliseylobanov.translator.ui.MainAdapter
import com.eliseylobanov.translator.view.BaseFragment
import com.eliseylobanov.translator.view.BaseView

class MainFragment : BaseFragment<AppState>(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    private var adapter: MainAdapter? = null

    override fun createPresenter(): MainPresenter<AppState, BaseView> {
        return MainPresenterImpl()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.searchFab.setOnClickListener {
            val searchDialogFragment = SearchDialogFragment.newInstance()
            searchDialogFragment.setOnSearchClickListener(object : SearchDialogFragment.OnSearchClickListener {
                override fun onClick(searchWord: String) {
                    presenter.getData(searchWord, true)
                }
            })
            searchDialogFragment.show(requireActivity().supportFragmentManager, BOTTOM_SHEET_FRAGMENT_DIALOG_TAG)
        }
        return binding.root
    }

    override fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val dataModel = appState.data
                if (dataModel == null || dataModel.isEmpty()) {
                    showErrorScreen(getString(R.string.empty_server_response_on_success))
                } else {
                    showViewSuccess()
                    if (adapter == null) {
                        val adapter = MainAdapter(MainAdapter.OnClickListener {
                            Toast.makeText(requireContext(), "Item clicked", Toast.LENGTH_SHORT).show()
                        })
                        adapter.submitList(dataModel)
                        binding.mainActivityRecyclerview.layoutManager = LinearLayoutManager(requireContext())
                        binding.mainActivityRecyclerview.adapter = adapter
                    }
                }
            }
            is AppState.Loading -> {
                showViewLoading()
                if (appState.progress != null) {
                    binding.progressBarHorizontal.visibility = View.VISIBLE
                    binding.progressBarRound.visibility = View.GONE
                    binding.progressBarHorizontal.progress = appState.progress
                } else {
                    binding.progressBarHorizontal.visibility = View.GONE
                    binding.progressBarRound.visibility = View.VISIBLE
                }
            }
            is AppState.Error -> {
                showErrorScreen(appState.error.message)
            }
        }
    }

    private fun showErrorScreen(error: String?) {
        showViewError()
        binding.errorTextview.text = error ?: getString(R.string.undefined_error)
        binding.reloadButton.setOnClickListener {
            presenter.getData("hi", true)
        }
    }

    private fun showViewSuccess() {
        binding.successLinearLayout.visibility = View.VISIBLE
        binding.loadingFrameLayout.visibility = View.GONE
        binding.errorLinearLayout.visibility = View.GONE
    }

    private fun showViewLoading() {
        binding.successLinearLayout.visibility = View.GONE
        binding.loadingFrameLayout.visibility = View.VISIBLE
        binding.errorLinearLayout.visibility = View.GONE
    }

    private fun showViewError() {
        binding.successLinearLayout.visibility = View.GONE
        binding.loadingFrameLayout.visibility = View.GONE
        binding.errorLinearLayout.visibility = View.VISIBLE
    }

    companion object {
        private const val BOTTOM_SHEET_FRAGMENT_DIALOG_TAG = "74a54328-5d62-46bf-ab6b-cbf5fgt0-092395"
    }
}