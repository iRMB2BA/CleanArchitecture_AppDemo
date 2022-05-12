package com.example.cleanarchitecture_appdemo.di

import android.content.Context
import com.example.cleanarchitecture_appdemo.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture_appdemo.domain.usecase.SaveUserNameUseCase
import com.example.cleanarchitecture_appdemo.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class AppModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }
    @Provides
    fun provideMainViewModelFactory(
         getUserNameUseCase: GetUserNameUseCase,
         saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )
    }
}