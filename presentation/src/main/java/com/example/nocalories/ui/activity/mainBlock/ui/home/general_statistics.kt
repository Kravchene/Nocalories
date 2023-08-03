package com.example.nocalories.ui.activity.mainBlock.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentAddAMealBinding
import com.example.nocalories.databinding.FragmentGeneralStatisticsBinding
import com.example.nocalories.databinding.FragmentLoginViaEmailBinding

class General_statistics : Fragment() {
    lateinit var binding: FragmentGeneralStatisticsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGeneralStatisticsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}