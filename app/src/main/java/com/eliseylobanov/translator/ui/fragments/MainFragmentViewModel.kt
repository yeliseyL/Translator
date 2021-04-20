package com.eliseylobanov.translator.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.model.darasource.DataSource
import com.eliseylobanov.translator.model.entities.DataModel
import com.eliseylobanov.translator.ui.BaseViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(
        private val dataSourceRemote: DataSource<AppState>) : BaseViewModel<AppState>() {

    private val _results = MutableLiveData<List<DataModel>?>()
    val results: LiveData<List<DataModel>?>
        get() = _results

    override fun getData(word: String) {
        compositeDisposable.add(
                dataSourceRemote.getData(word)
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .doOnSubscribe(doOnSubscribe())
                        .subscribeWith(getObserver())
        )
    }

    private fun doOnSubscribe(): (Disposable) -> Unit =
            { liveDataForViewToObserve.value = AppState.Loading(null) }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(state: AppState) {
                when (state) {
                    is AppState.Success -> {
                        _results.value = state.data
                    }
                }
            }

            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = AppState.Error(e)
            }

            override fun onComplete() {
            }
        }
    }
}