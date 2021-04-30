package com.eliseylobanov.translator.view

import androidx.fragment.app.Fragment

abstract class BaseFragment<T : com.eliseylobanov.repository.AppState>(layoutId: Int) : Fragment(layoutId), BaseView {

    abstract override fun renderData(appState: com.eliseylobanov.repository.AppState)

}
