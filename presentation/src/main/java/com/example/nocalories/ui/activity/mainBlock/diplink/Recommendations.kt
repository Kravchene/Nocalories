package com.example.nocalories.ui.activity.mainBlock.diplink

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentRecipesBinding
import com.example.nocalories.databinding.FragmentRecommendationsBinding

class Recommendations : Fragment() {
    lateinit var binding: FragmentRecommendationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecommendationsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}