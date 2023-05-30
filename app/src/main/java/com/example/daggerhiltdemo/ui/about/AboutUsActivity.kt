package com.example.daggerhiltdemo.ui.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerhiltdemo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.aboutus_fragment_container, AboutUsFragment.newInstance()).commit()
        } else {
            val fragment = supportFragmentManager.findFragmentById(R.id.aboutus_fragment_container)
            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.aboutus_fragment_container, it).commit()
            }
        }

    }
}