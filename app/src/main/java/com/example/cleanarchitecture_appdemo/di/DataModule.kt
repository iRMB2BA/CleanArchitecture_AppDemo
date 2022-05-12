package com.example.cleanarchitecture_appdemo.di

import android.content.Context
import com.example.cleanarchitecture_appdemo.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture_appdemo.data.storage.UserStorage
import com.example.cleanarchitecture_appdemo.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarchitecture_appdemo.domain.repository.UserRepository
import dagger.Module
import dagger.Provides


@Module
class DataModule {
    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }
    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}