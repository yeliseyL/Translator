package com.eliseylobanov.repository.darasource

import com.eliseylobanov.repository.repository.RepositoryLocal
import com.eliseylobanov.translator.model.entities.DataModel

class DataSourceLocalImpl(private val database: RepositoryLocal<DataModel>) :
    DataSourceLocal<List<DataModel>> {
    override suspend fun getAll(): List<DataModel> {
       return database.getAll()
    }

    override suspend fun saveToDB(word: DataModel) {
        database.saveToDB(word)
    }
}
