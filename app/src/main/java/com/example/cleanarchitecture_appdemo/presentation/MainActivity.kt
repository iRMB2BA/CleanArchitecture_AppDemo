package com.example.cleanarchitecture_appdemo.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture_appdemo.R

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.tv_getData)
        val dataEditView = findViewById<EditText>(R.id.et_saveData)
        val sendButton = findViewById<Button>(R.id.btn_saveData)
        val getButton = findViewById<Button>(R.id.btn_getdata)

        vm.liveData.observe(this) {
            dataTextView.text = it
        }

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            vm.save(text)
        }

        getButton.setOnClickListener {
            vm.load()
        }
    }
}