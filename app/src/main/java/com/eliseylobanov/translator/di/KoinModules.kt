package com.eliseylobanov.translator.di

import androidx.room.Room
import com.eliseylobanov.repository.AppState
import com.eliseylobanov.repository.darasource.DataSource
import com.eliseylobanov.repository.darasource.DataSourceLocal
import com.eliseylobanov.repository.darasource.DataSourceLocalImpl
import com.eliseylobanov.repository.darasource.DataSourceRemote
import com.eliseylobanov.repository.database.RoomDataBaseImplementation
import com.eliseylobanov.repository.database.WordDatabase
import com.eliseylobanov.repository.retrofit.RetrofitImplementation

import com.eliseylobanov.translator.model.entities.DataModel

import com.eliseylobanov.translator.ui.fragments.HistoryViewModel
import com.eliseylobanov.translator.ui.fragments.MainFragmentViewModel
import org.koin.dsl.module

val application = module {
    single<DataSource<AppState>>{ DataSourceRemote(RetrofitImplementation()) }
    single { Room.databaseBuilder(get(), WordDatabase::class.java, "HistoryDB").build() }
    single { get<WordDatabase>().wordDao }
    single<DataSourceLocal<List<DataModel>>> {
        DataSourceLocalImpl(RoomDataBaseImplementation(get()))
    }
}

val mainscreen = module { factory { MainFragmentViewModel(get(), get()) } }

val historyScreen = module { factory { HistoryViewModel(get()) } }
