package com.eliseylobanov.repository.darasource

import com.eliseylobanov.repository.AppState
import com.eliseylobanov.repository.repository.Repository
import com.eliseylobanov.translator.model.entities.DataModel

class DataSourceRemote(private val remoteProvider: Repository<List<DataModel>>) :
    DataSource<AppState> {
    override suspend fun getData(word: String): AppState =
        AppState.Success(remoteProvider.getData(word))
}
