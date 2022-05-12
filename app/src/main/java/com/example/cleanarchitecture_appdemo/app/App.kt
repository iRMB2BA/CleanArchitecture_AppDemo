package com.example.cleanarchitecture_appdemo.app

import android.app.Application
import com.example.cleanarchitecture_appdemo.di.AppComponent
import com.example.cleanarchitecture_appdemo.di.AppModule
import com.example.cleanarchitecture_appdemo.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(context = this)).build()
    }
}