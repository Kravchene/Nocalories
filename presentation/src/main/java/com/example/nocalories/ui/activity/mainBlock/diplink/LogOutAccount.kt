package com.example.nocalories.ui.activity.mainBlock.diplink

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit

import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.pawegio.kandroid.defaultSharedPreferences
import com.example.nocalories.databinding.FragmentLogOutAccountBinding



class LogOutAccount : Fragment() {
    lateinit var binding: FragmentLogOutAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogOutAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefs =requireActivity().defaultSharedPreferences
        with (binding){
            buttonNo.setOnClickListener {
                findNavController().navigate(R.id.nav_home)
            }
            buttonYes.setOnClickListener {
                prefs.edit {
                    putBoolean("CHECK", false)
                }
                findNavController().navigate(R.id.registration_or_Login)
            }
        }
    }
}