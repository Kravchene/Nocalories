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
                transition()
            }
            add500.setOnClickListener {
                transition()
            }
            add1000.setOnClickListener {
                transition()
            }
            if (itsValue.isNotEmpty()) {
                add.setOnClickListener {
                    transition()
                }
            }
            waterAdvice.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(resources.getString(R.string.link_water))
                    )
                )

            }
        }
    }
    fun transition(){
        findNavController().navigate(R.id.action_addWater2_to_nav_home)
    }
}