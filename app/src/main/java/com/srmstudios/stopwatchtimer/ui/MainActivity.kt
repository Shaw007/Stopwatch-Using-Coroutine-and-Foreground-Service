package com.srmstudios.stopwatchtimer.ui

import android.os.Bundle
import android.view.LayoutInflater
import com.srmstudios.stopwatchtimer.util.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
            = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}