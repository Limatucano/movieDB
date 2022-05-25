package com.br.matheus.correa.moviedb.view

import android.graphics.DiscretePathEffect
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.br.matheus.correa.moviedb.R
import com.br.matheus.correa.moviedb.databinding.FragmentSplashScreenBinding
import kotlinx.coroutines.*
import java.util.*
import kotlin.concurrent.timerTask

class SplashScreenFragment : Fragment() {

    private lateinit var viewBinding : FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            val direction = SplashScreenFragmentDirections.actionSplashScreenFragmentToMainScreenFragment()
            view.findNavController().navigate(direction)
        }
    }

}