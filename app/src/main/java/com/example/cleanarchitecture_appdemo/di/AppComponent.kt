package com.example.cleanarchitecture_appdemo.di

import com.example.cleanarchitecture_appdemo.presentation.MainActivity
import dagger.Component


@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}