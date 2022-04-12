package com.example.cleanarchitecture_appdemo.domain.usecase

import com.example.cleanarchitecture_appdemo.domain.models.UserName

class GetUserNameUseCase {
    fun execute(): UserName {
        return UserName(firstName = "Rombaba", lastName = "Hello")
    }
}