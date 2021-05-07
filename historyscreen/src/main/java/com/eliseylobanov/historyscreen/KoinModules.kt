package com.eliseylobanov.historyscreen

import com.eliseylobanov.translator.ui.MainActivity
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun injectDependencies() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(listOf(historyScreen))
}

val historyScreen = module {
    scope(named<MainActivity>()) {
        viewModel { HistoryViewModel(get()) }
    }
}