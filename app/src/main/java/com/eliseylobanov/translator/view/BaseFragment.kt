package com.eliseylobanov.translator.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.presenter.MainPresenter

abstract class BaseFragment<T : AppState>(layoutId: Int) : Fragment(layoutId), BaseView {

    protected lateinit var presenter: MainPresenter<T, BaseView>

    protected abstract fun createPresenter(): MainPresenter<T, BaseView>

    abstract override fun renderData(appState: AppState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }
}
