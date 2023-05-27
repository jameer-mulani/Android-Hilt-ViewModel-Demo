package com.example.daggerhiltdemo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.daggerhiltdemo.R
import com.example.daggerhiltdemo.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.users.observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    Log.d("mainactivity", "state loading")
                }

                Status.FAILED -> {
                    Log.d("mainactivity", "state failed : ${it.message}")
                }

                Status.SUCCESS -> {
                    Log.d("mainactivity", "state success : ${it.data}")
                }
            }
        }

    }
}