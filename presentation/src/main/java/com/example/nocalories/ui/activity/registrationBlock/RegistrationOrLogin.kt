package com.example.nocalories.ui.activity.registrationBlock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentRegistrationOrLoginBinding


class RegistrationOrLogin : Fragment() {
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
        with(binding) {
            buttonRegister.setOnClickListener {
                findNavController().navigate(R.id.action_registration_or_Login_to_registration_Stage_1)
            }
            buttonEntrance.setOnClickListener {
                findNavController().navigate(R.id.action_registration_or_Login_to_entryStage2)
            }

        }
    }
}