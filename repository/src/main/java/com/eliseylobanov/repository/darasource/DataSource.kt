package com.eliseylobanov.repository.darasource

interface DataSource<T> {
    suspend fun getData(word: String): T
}
