package com.eliseylobanov.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eliseylobanov.translator.model.entities.DataModel

@Entity(tableName = "word_table")
data class DatabaseDataModel(
    @PrimaryKey
    val text: String
)

fun List<DatabaseDataModel>.asDomainModel(): ArrayList<DataModel> {
    return map {
        DataModel(
            text = it.text,
            meanings = null)
    } as ArrayList<DataModel>
}