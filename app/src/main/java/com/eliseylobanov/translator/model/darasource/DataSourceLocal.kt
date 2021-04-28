package com.eliseylobanov.translator.model.darasource

import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.model.entities.DataModel

interface DataSourceLocal<T> {
    suspend fun getAll(): List<DataModel>
    suspend fun saveToDB(word: DataModel)
}
