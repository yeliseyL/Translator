package com.eliseylobanov.translator.model.repository

import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.model.darasource.DataSourceLocal
import com.eliseylobanov.translator.model.entities.DataModel

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<DataModel>>) :
    RepositoryLocal<List<DataModel>> {

    override suspend fun getAll(): List<DataModel> {
        return dataSource.getAll()
    }

    override suspend fun saveToDB(word: DataModel) {
        dataSource.saveToDB(word)
    }
}