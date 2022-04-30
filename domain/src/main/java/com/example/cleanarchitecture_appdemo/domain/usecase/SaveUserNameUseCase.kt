package com.example.cleanarchitecture_appdemo.domain.usecase

import com.example.cleanarchitecture_appdemo.domain.models.SaveUserNameParam
import com.example.cleanarchitecture_appdemo.domain.repository.UserRepository

class SaveUserNameUseCase(private val userPepository : UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {
        return userPepository.saveName(saveParam = param)

    }
}