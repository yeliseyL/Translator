package com.eliseylobanov.translator.model.darasource

import io.reactivex.Observable

interface DataSource<T> {
    fun getData(word: String): Observable<T>
}
