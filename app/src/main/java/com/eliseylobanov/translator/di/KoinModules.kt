package com.eliseylobanov.translator.di

import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.model.darasource.DataSource
import com.eliseylobanov.translator.model.darasource.DataSourceRemote
import com.eliseylobanov.translator.model.retrofit.RetrofitImplementation
import com.eliseylobanov.translator.ui.fragments.MainFragmentViewModel
import org.koin.dsl.module

val application = module {
    single<DataSource<AppState>>{ DataSourceRemote(RetrofitImplementation()) }
}

val mainscreen = module {
    factory { MainFragmentViewModel(get()) }
}