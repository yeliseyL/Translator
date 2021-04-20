package com.eliseylobanov.translator.model.darasource

import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.model.entities.DataModel
import com.eliseylobanov.translator.model.repository.Repository
import io.reactivex.Observable

class DataSourceRemote(private val remoteProvider: Repository<List<DataModel>>) :
    DataSource<AppState> {
    override fun getData(word: String): Observable<AppState> = remoteProvider.getData(word).map { AppState.Success(it) }
}
