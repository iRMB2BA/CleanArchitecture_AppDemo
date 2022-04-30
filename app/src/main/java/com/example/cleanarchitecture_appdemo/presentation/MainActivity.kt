package com.example.cleanarchitecture_appdemo.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecture_appdemo.R
import com.example.cleanarchitecture_appdemo.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture_appdemo.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarchitecture_appdemo.domain.models.SaveUserNameParam
import com.example.cleanarchitecture_appdemo.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture_appdemo.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext))
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository)
    }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository)
    }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.tv_getData)
        val dataEditView = findViewById<EditText>(R.id.et_saveData)
        val sendButton = findViewById<Button>(R.id.btn_saveData)
        val getButton = findViewById<Button>(R.id.btn_getdata)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val params = SaveUserNameParam(name = text)
            val result : Boolean = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save Result = $result"
        }

        getButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}