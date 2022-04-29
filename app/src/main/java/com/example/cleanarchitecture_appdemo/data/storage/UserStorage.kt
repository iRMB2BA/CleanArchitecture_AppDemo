package com.example.cleanarchitecture_appdemo.data.storage

import com.example.cleanarchitecture_appdemo.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}