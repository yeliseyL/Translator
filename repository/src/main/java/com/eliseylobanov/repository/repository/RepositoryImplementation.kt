package com.eliseylobanov.repository.repository

import com.eliseylobanov.repository.retrofit.RetrofitImplementation
import com.eliseylobanov.translator.model.entities.DataModel

class RepositoryImplementation(private val dataSource: RetrofitImplementation) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
