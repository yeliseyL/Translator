package com.eliseylobanov.translator.model.repository

import com.eliseylobanov.translator.model.entities.DataModel
import com.eliseylobanov.translator.model.retrofit.RetrofitImplementation
import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: RetrofitImplementation) :
    Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}
