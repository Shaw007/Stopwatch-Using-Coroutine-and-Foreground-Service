package com.srmstudios.stopwatchtimer.util

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/*
*
* Helper Base class for ViewBinding
* Author: Shahrukh Malik
* shahrukhm92@gmail.com
*
* */
abstract class BaseFragment<VB : ViewBinding>(layoutResId: Int) : Fragment(layoutResId) {

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (View) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = bindingInflater.invoke(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}










