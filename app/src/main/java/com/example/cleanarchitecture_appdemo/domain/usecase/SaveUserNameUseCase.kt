package com.example.cleanarchitecture_appdemo.domain.usecase

import com.example.cleanarchitecture_appdemo.domain.models.SaveUserNameParam

class SaveUserNameUseCase {
    fun execute(param: SaveUserNameParam) : Boolean {
        return param.name.isNotEmpty()
    }
}