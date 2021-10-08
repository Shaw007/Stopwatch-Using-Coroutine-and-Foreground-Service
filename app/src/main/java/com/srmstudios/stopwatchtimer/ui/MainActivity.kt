package com.srmstudios.stopwatchtimer.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.srmstudios.stopwatchtimer.R
import com.srmstudios.stopwatchtimer.databinding.ActivityMainBinding
import com.srmstudios.stopwatchtimer.util.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
            = ActivityMainBinding::inflate

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
            .navController

        setupActionBarWithNavController(navController)
    }
}