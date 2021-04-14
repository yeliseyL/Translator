package com.eliseylobanov.translator.presenter

import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.view.BaseView

interface MainPresenter<T : AppState, V : BaseView> {
    fun attachView(view: V)
    fun detachView(view: V)
    fun getData(word: String, isOnline: Boolean)
}
