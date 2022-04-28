package com.example.cleanarchitecture_appdemo.domain.repository

import com.example.cleanarchitecture_appdemo.domain.models.SaveUserNameParam
import com.example.cleanarchitecture_appdemo.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam : SaveUserNameParam): Boolean

    fun getName() : UserName
}