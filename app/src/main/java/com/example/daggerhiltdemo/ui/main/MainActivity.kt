package com.example.daggerhiltdemo.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.example.daggerhiltdemo.R
import com.example.daggerhiltdemo.databinding.ActivityMainBinding
import com.example.daggerhiltdemo.ui.about.AboutUsActivity
import com.example.daggerhiltdemo.ui.about.AboutUsViewModel
import com.example.daggerhiltdemo.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()



    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_about_us -> {

                val intent = Intent(MainActivity@this, AboutUsActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}