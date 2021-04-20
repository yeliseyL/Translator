package com.eliseylobanov.translator.di

import com.eliseylobanov.translator.model.AppState
import com.eliseylobanov.translator.model.darasource.DataSource
import com.eliseylobanov.translator.model.darasource.DataSourceRemote
import com.eliseylobanov.translator.model.entities.DataModel
import com.eliseylobanov.translator.model.repository.Repository
import com.eliseylobanov.translator.model.retrofit.RetrofitImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideRepositoryRemote(): Repository<List<DataModel>> = RetrofitImplementation()

    @Provides
    @Singleton
    internal fun provideDataSourceRemote(repositoryRemote: Repository<List<DataModel>>): DataSource<AppState> =
        DataSourceRemote(repositoryRemote)
}
