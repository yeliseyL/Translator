package com.eliseylobanov.translator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eliseylobanov.translator.R
import com.eliseylobanov.translator.di.injectDependencies

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        setContentView(R.layout.activity_main)
    }
}