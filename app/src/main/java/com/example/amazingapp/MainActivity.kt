package com.example.amazingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.amazingapp.ui.SettingsFragment
import com.example.amazingapp.ui.picture.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.CustomTheme)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                .commitNow()
        }
    }
}