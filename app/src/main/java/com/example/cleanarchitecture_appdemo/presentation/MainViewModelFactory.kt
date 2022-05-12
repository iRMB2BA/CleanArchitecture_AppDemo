package com.example.cleanarchitecture_appdemo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture_appdemo.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture_appdemo.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}