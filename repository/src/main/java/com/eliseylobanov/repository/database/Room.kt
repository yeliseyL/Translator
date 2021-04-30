package com.eliseylobanov.repository.database

import androidx.room.*
import com.eliseylobanov.model.entities.DatabaseDataModel

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