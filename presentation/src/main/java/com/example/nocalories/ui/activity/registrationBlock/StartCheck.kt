package com.example.nocalories.ui.activity.registrationBlock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.pawegio.kandroid.defaultSharedPreferences

class StartCheck : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start__check, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefs = requireActivity().defaultSharedPreferences

        if (prefs.getBoolean("CHECK", false)) {
            findNavController().navigate(R.id.action_startCheck_to_noCaloriesActivityNav)
        } else {
            findNavController().navigate(R.id.action_startCheck_to_registration_or_Login)
        }


    }
}