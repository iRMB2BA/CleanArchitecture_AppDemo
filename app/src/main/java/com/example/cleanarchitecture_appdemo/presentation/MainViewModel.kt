package com.example.cleanarchitecture_appdemo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture_appdemo.domain.models.SaveUserNameParam
import com.example.cleanarchitecture_appdemo.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture_appdemo.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val resultLiveData = MutableLiveData<String>()
    val liveData: LiveData<String> = resultLiveData



    fun save(text : String) {
        val params = SaveUserNameParam(name = text)
        val result : Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveData.value =  "Save Result = $result"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        resultLiveData.value =  "${userName.firstName} ${userName.lastName}"
    }

}