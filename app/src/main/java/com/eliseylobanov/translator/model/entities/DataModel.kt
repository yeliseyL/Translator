package com.eliseylobanov.translator.model.entities

import android.os.Parcelable
import com.eliseylobanov.translator.model.database.DatabaseDataModel
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel(
    @field:SerializedName("text") val text: String,
    @field:SerializedName("meanings") val meanings: List<Meanings>?
) : Parcelable


internal val DataModel.toDatabaseDataModel: DatabaseDataModel
    get() = DatabaseDataModel(
        text = this.text
    )