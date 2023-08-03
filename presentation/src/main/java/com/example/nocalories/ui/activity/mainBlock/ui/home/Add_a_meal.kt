package com.example.nocalories.ui.activity.mainBlock.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentAddAMealBinding
import com.example.nocalories.databinding.FragmentGeneralStatisticsBinding

class Add_a_meal : Fragment() {
    lateinit var binding: FragmentAddAMealBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddAMealBinding.inflate(layoutInflater, container, false)
        return binding.root

    }
    companion object{
        @JvmStatic
        fun fragment()=Fragment()
    }
}