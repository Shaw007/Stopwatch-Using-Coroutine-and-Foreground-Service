package com.srmstudios.stopwatchtimer.util

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/*
*
* Helper Base class for ViewBinding
* Author: Shahrukh Malik
* shahrukhm92@gmail.com
*
* */
abstract class BaseActivity<T : ViewBinding>: AppCompatActivity() {

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> T

    @Suppress("UNCHECKED_CAST")
    protected val binding: T
        get() = _binding as T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}