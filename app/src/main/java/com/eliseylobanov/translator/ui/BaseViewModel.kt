package com.eliseylobanov.translator.ui

import androidx.lifecycle.ViewModel
import com.eliseylobanov.translator.model.AppState

abstract class BaseViewModel<T : AppState>: ViewModel() {

    abstract fun getData(word: String)

}