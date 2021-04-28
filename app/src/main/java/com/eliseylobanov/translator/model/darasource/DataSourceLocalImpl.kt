package com.eliseylobanov.translator.model.darasource

import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.model.entities.DataModel
import com.eliseylobanov.translator.model.repository.Repository
import com.eliseylobanov.translator.model.repository.RepositoryLocal

class DataSourceLocalImpl(private val database: RepositoryLocal<DataModel>) :
        DataSourceLocal<List<DataModel>> {
    override suspend fun getAll(): List<DataModel> {
       return database.getAll()
    }

    override suspend fun saveToDB(word: DataModel) {
        database.saveToDB(word)
    }
}
