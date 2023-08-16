package com.example.nocalories.ui.activity.mainBlock.diplink

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(resources.getString(R.string.link_loss_link))
            )
        )
    }
    override fun onPause() {
        findNavController().navigate(R.id.nav_home)
        super.onPause()

    }

}