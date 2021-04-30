package com.eliseylobanov.translator.ui

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T : com.eliseylobanov.repository.AppState>: ViewModel() {

    abstract fun getData(word: String)

}