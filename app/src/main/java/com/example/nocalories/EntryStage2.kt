package com.example.nocalories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nocalories.databinding.FragmentEntryStage2Binding
import com.example.nocalories.databinding.FragmentRegistrationOrLoginBinding
import com.example.nocalories.databinding.FragmentRegistrationStage1Binding

class EntryStage2 : Fragment() {
    lateinit var binding: FragmentEntryStage2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEntryStage2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}