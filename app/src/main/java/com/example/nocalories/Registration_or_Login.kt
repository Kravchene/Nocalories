package com.example.nocalories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.nocalories.databinding.FragmentRegistrationOrLoginBinding
import com.example.nocalories.databinding.FragmentRegistrationStage1Binding


class Registration_or_Login : Fragment() {
    lateinit var binding: FragmentRegistrationOrLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationOrLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonRegister.setOnClickListener{
            findNavController().navigate(R.id.action_registration_or_Login_to_registration_Stage_1)
        }
    }
}