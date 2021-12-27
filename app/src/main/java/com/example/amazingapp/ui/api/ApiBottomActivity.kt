package com.example.amazingapp.ui.api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.amazingapp.R
import com.example.amazingapp.databinding.ActivityBottomApiBinding

class ApiBottomActivity : AppCompatActivity() {
    lateinit var binding: ActivityBottomApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_view_earth -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, EarthFragment()).commit()
                    true
                }
                R.id.bottom_view_mars -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, MarsFragment()).commit()
                    true
                }
                R.id.bottom_view_system -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SystemFragment()).commit()
                    true
                }
                else -> {
                    false
                }
            }
        }
        binding.bottomNavigationView.selectedItemId = R.id.bottom_view_earth
//        val badge = binding.bottomNavigationView.getOrCreateBadge(R.id.bottom_view_system)
//        badge.number = 999
//        badge.maxCharacterCount = 3
    }


}