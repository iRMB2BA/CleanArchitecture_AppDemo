package com.example.cleanarchitecture_appdemo.di

import com.example.cleanarchitecture_appdemo.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture_appdemo.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userPepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userPepository = get())
    }
}