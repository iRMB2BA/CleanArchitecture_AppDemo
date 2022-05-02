package com.example.cleanarchitecture_appdemo.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture_appdemo.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture_appdemo.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarchitecture_appdemo.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture_appdemo.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userPepository = userRepository)
    }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userPepository = userRepository)
    }



    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}