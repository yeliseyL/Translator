package com.eliseylobanov.translator.app

import android.app.Application
import com.eliseylobanov.translator.di.application
import com.eliseylobanov.translator.di.mainscreen
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainscreen))
        }
    }
}