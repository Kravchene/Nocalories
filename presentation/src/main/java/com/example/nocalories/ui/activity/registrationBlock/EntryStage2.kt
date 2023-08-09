package com.example.nocalories.ui.activity.registrationBlock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentEntryStage2Binding

class EntryStage2 : Fragment() {
    lateinit var binding: FragmentEntryStage2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEntryStage2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            buttonBack.setOnClickListener {
                findNavController().navigate(R.id.action_entryStage2_to_registration_or_Login)
            }
            buttonLoginViaEmail.setOnClickListener {
                findNavController().navigate(R.id.action_entryStage2_to_login_via_email)
            }
            buttonLoginViaGoogle.setOnClickListener {

            }
        }
    }
}