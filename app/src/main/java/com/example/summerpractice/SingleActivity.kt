package com.example.summerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class SingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
        findViewById<BottomNavigationView>(R.id.bnv_main).apply {
            val controller = (supportFragmentManager.findFragmentById(R.id.container)
                    as NavHostFragment).navController
            setupWithNavController(controller)
        }
    }
}