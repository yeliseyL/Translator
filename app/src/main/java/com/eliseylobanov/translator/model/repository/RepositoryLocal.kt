package com.eliseylobanov.translator.model.repository

import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.model.entities.DataModel

interface RepositoryLocal<T>{
    suspend fun getAll() : List<DataModel>
    suspend fun saveToDB(word: DataModel)
}
