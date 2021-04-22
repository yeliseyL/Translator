package com.eliseylobanov.translator.model.darasource

interface DataSource<T> {
    suspend fun getData(word: String): T
}
