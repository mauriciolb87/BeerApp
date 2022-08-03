package com.example.beerapiapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.beerapiapp.R
import com.example.beerapiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val navHostFragment =
            (supportFragmentManager.findFragmentById(_binding.navFragment.id) as NavHostFragment)

        val navController = navHostFragment.navController
        _binding.bottomNavigation.setupWithNavController(navController)

    }

}