package com.eliseylobanov.translator.view

import androidx.fragment.app.Fragment
import com.eliseylobanov.translator.model.AppState

abstract class BaseFragment<T : AppState>(layoutId: Int) : Fragment(layoutId), BaseView {

    abstract override fun renderData(appState: AppState)

}
