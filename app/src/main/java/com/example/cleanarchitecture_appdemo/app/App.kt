package com.example.cleanarchitecture_appdemo.app

import android.app.Application
import com.example.cleanarchitecture_appdemo.di.appModule
import com.example.cleanarchitecture_appdemo.di.dataModule
import com.example.cleanarchitecture_appdemo.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}