package com.eliseylobanov.translator.view

import com.eliseylobanov.translator.model.AppState

interface BaseView {
    fun renderData(appState: AppState)
}