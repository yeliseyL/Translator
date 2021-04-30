package com.eliseylobanov.repository.database

import com.eliseylobanov.model.entities.asDomainModel
import com.eliseylobanov.repository.repository.RepositoryLocal
import com.eliseylobanov.translator.model.entities.DataModel
import com.eliseylobanov.translator.model.entities.toDatabaseDataModel

class RoomDataBaseImplementation(private val historyDao: WordDao) :
    RepositoryLocal<DataModel> {

    override suspend fun getAll(): List<DataModel> {
        return historyDao.getAllWords().asDomainModel()
    }

    override suspend fun saveToDB(word: DataModel) {
        historyDao.insert(word.toDatabaseDataModel)
    }
}
