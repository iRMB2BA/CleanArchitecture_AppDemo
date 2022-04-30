package com.example.cleanarchitecture_appdemo.domain.usecase

import com.example.cleanarchitecture_appdemo.domain.models.UserName
import com.example.cleanarchitecture_appdemo.domain.repository.UserRepository

class GetUserNameUseCase(private val userPepository : UserRepository) {

    fun execute(): UserName {
        return userPepository.getName()
    }
}