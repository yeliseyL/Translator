package com.eliseylobanov.translator.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<T : AppState>(
        protected open val liveDataForViewToObserve: MutableLiveData<T> = MutableLiveData(),
        protected open val compositeDisposable: CompositeDisposable = CompositeDisposable(),
        protected open val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel() {

    abstract fun getData(word: String)

    override fun onCleared() {
        compositeDisposable.clear()
    }
}