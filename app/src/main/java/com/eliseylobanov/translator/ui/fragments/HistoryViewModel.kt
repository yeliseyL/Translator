package com.eliseylobanov.translator.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.eliseylobanov.repository.darasource.DataSourceLocal
import com.eliseylobanov.translator.model.entities.DataModel
import kotlinx.coroutines.launch

class HistoryViewModel(
        private val dataSourceLocal: DataSourceLocal<List<DataModel>>
) : ViewModel() {

    private val _history = MutableLiveData<List<DataModel>?>()
    val history: LiveData<List<DataModel>?>
        get() = _history

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            _history.value = dataSourceLocal.getAll()
        }
    }

}