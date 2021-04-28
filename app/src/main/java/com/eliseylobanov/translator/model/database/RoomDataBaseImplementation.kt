package com.eliseylobanov.translator.model.database

import com.eliseylobanov.translator.model.entities.DataModel
import com.eliseylobanov.translator.model.entities.toDatabaseDataModel
import com.eliseylobanov.translator.model.repository.RepositoryLocal

class RoomDataBaseImplementation(private val historyDao: WordDao) :
    RepositoryLocal<DataModel> {

    override suspend fun getAll(): List<DataModel> {
        return historyDao.getAllWords().asDomainModel()
    }

    override suspend fun saveToDB(word: DataModel) {
        historyDao.insert(word.toDatabaseDataModel)
    }
}
