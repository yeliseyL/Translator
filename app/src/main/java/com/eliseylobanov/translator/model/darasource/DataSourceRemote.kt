package com.eliseylobanov.translator.model.darasource

import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.model.entities.DataModel
import com.eliseylobanov.translator.model.repository.Repository

class DataSourceRemote(private val remoteProvider: Repository<List<DataModel>>) :
    DataSource<AppState> {
    override suspend fun getData(word: String): AppState = AppState.Success(remoteProvider.getData(word))
}
