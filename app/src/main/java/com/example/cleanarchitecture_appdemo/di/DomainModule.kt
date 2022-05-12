package com.example.cleanarchitecture_appdemo.di

import com.example.cleanarchitecture_appdemo.domain.repository.UserRepository
import com.example.cleanarchitecture_appdemo.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture_appdemo.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides


@Module
class DomainModule {
    @Provides
    fun provideGetUserNameUseCase(userRepository : UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userPepository = userRepository)
    }
    @Provides
    fun provideSaveUsernameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userPepository = userRepository)
    }
}