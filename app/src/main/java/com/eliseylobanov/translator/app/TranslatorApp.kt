package com.eliseylobanov.translator.app

import android.app.Application
import com.eliseylobanov.translator.di.AppComponent
import com.eliseylobanov.translator.di.DaggerAppComponent

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val component = DaggerAppComponent.builder().appContent(this).build()
        TranslatorApp.component = component
    }

    companion object {
        lateinit var component: AppComponent
    }

}