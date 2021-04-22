package com.eliseylobanov.translator.model.repository

import com.eliseylobanov.translator.model.entities.DataModel
import com.eliseylobanov.translator.model.retrofit.RetrofitImplementation

class RepositoryImplementation(private val dataSource: RetrofitImplementation) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
