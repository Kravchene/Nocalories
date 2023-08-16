package com.example.nocalories.ui.activity.mainBlock.diplink

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentRecipesBinding

class Recipes : Fragment() {
    lateinit var binding: FragmentRecipesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(resources.getString(R.string.link_to_recipes))))
    }
    override fun onPause() {
        findNavController().navigate(R.id.nav_home)
        super.onPause()

    }
}