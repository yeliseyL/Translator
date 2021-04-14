package com.eliseylobanov.translator.model.darasource

import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.model.retrofit.RetrofitImplementation
import io.reactivex.Observable

class DataSourceRemote(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource<AppState> {
    override fun getData(word: String): Observable<AppState> = remoteProvider.getData(word).map { AppState.Success(it) }
}
