package com.eliseylobanov.repository.darasource

import com.eliseylobanov.translator.model.entities.DataModel

interface DataSourceLocal<T> {
    suspend fun getAll(): List<DataModel>
    suspend fun saveToDB(word: DataModel)
}
