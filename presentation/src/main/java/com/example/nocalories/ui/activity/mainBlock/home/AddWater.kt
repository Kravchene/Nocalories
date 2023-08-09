package com.example.nocalories.ui.activity.mainBlock.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isNotEmpty
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentAddWaterBinding

class AddWater : Fragment() {
    lateinit var binding: FragmentAddWaterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddWaterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            add250.setOnClickListener {
                findNavController().navigate(R.id.action_addWater2_to_nav_home)
            }
            add500.setOnClickListener {
                findNavController().navigate(R.id.action_addWater2_to_nav_home)
            }
            add1000.setOnClickListener {
                findNavController().navigate(R.id.action_addWater2_to_nav_home)
            }
            if (itsValue.isNotEmpty()) {
                add.setOnClickListener {
                    findNavController().navigate(R.id.action_addWater2_to_nav_home)
                }
            }
            waterAdvice.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://profilaktica.ru/for-population/profilaktika-zabolevaniy/vse-o-pravilnom-pitanii/skolko-vody-nuzhno-pit-v-den/")
                    )
                )

            }
        }
    }
}