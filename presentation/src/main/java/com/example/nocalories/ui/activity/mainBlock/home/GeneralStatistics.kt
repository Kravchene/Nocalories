package com.example.nocalories.ui.activity.mainBlock.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentGeneralStatisticsBinding

class GeneralStatistics : Fragment() {
    lateinit var binding: FragmentGeneralStatisticsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGeneralStatisticsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            buttonBreakfast.setOnClickListener {
                moving()
            }
            buttonSecondBreakfast.setOnClickListener {
                moving()
            }
            buttonLunch.setOnClickListener {
                moving()
            }
            buttonAfternoonSnack.setOnClickListener {
                moving()
            }
            buttonSupper.setOnClickListener {
                moving()
            }
            buttonSecondDinner.setOnClickListener {
                moving()
            }

        }

    }

    private fun moving() {
        findNavController().navigate(R.id.action_nav_home_to_foodCatalog)
    }

}