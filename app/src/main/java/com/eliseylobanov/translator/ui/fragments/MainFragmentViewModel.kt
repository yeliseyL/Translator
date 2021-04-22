package com.eliseylobanov.translator.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.model.darasource.DataSource
import com.eliseylobanov.translator.model.entities.DataModel
import com.eliseylobanov.translator.ui.BaseViewModel
import kotlinx.coroutines.launch

class MainFragmentViewModel(
        private val dataSourceRemote: DataSource<AppState>) : BaseViewModel<AppState>() {

    private val _results = MutableLiveData<List<DataModel>?>()
    val results: LiveData<List<DataModel>?>
        get() = _results

    override fun getData(word: String) {
        viewModelScope.launch {
            when (val state = dataSourceRemote.getData(word)) {
                is AppState.Success -> {
                    _results.value = state.data
                }
            }
        }
    }
}