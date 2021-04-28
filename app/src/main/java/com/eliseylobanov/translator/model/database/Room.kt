package com.eliseylobanov.translator.model.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {
    @Query("SELECT * FROM word_table")
    suspend fun getAllWords(): List<DatabaseDataModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: DatabaseDataModel)
}

@Database(entities = [DatabaseDataModel::class], version = 1)
abstract class WordDatabase : RoomDatabase() {
    abstract val wordDao: WordDao
}