package com.eliseylobanov.translator.di

import android.content.Context
import com.eliseylobanov.translator.ui.fragments.MainFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        ViewModelModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContent(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(fragment: MainFragment)
}