package com.eliseylobanov.translator.di

import androidx.room.Room
import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.model.darasource.DataSource
import com.eliseylobanov.translator.model.darasource.DataSourceLocal
import com.eliseylobanov.translator.model.darasource.DataSourceLocalImpl
import com.eliseylobanov.translator.model.darasource.DataSourceRemote
import com.eliseylobanov.translator.model.database.RoomDataBaseImplementation
import com.eliseylobanov.translator.model.database.WordDatabase
import com.eliseylobanov.translator.model.entities.DataModel
import com.eliseylobanov.translator.model.repository.RepositoryImplementationLocal
import com.eliseylobanov.translator.model.repository.RepositoryLocal
import com.eliseylobanov.translator.model.retrofit.RetrofitImplementation
import com.eliseylobanov.translator.ui.fragments.HistoryViewModel
import com.eliseylobanov.translator.ui.fragments.MainFragmentViewModel
import org.koin.dsl.module

val application = module {
    single<DataSource<AppState>>{ DataSourceRemote(RetrofitImplementation()) }
    single { Room.databaseBuilder(get(), WordDatabase::class.java, "HistoryDB").build() }
    single { get<WordDatabase>().wordDao }
    single<DataSourceLocal<List<DataModel>>> {
        DataSourceLocalImpl(
            RoomDataBaseImplementation(get())
        )
    }
}

val mainscreen = module { factory { MainFragmentViewModel(get(), get()) } }

val historyScreen = module { factory { HistoryViewModel(get()) } }
