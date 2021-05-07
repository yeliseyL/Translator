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

import com.eliseylobanov.translator.ui.fragments.MainFragmentViewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectDependencies() = loadModules

private val loadModules by lazy {
    loadKoinModules(listOf(application, mainScreen))
}

val application = module {
    single<DataSource<AppState>>{ DataSourceRemote(RetrofitImplementation()) }
    single { Room.databaseBuilder(get(), WordDatabase::class.java, "HistoryDB").build() }
    single { get<WordDatabase>().wordDao }
    single<DataSourceLocal<List<DataModel>>> {
        DataSourceLocalImpl(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module { factory { MainFragmentViewModel(get(), get()) } }




