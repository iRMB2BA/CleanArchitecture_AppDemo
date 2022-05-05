package com.example.cleanarchitecture_appdemo.di

import com.example.cleanarchitecture_appdemo.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture_appdemo.data.storage.UserStorage
import com.example.cleanarchitecture_appdemo.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarchitecture_appdemo.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}
