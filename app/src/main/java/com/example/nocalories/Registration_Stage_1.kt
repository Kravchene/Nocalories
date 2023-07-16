package com.example.nocalories

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.nocalories.databinding.FragmentRegistrationStage1Binding


class Registration_Stage_1 : Fragment() {
    lateinit var binding: FragmentRegistrationStage1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationStage1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val autoCompleteTextView: AutoCompleteTextView = binding.autoCompleteTextView

        val goal = resources.getStringArray((R.array.Goal))
        val arrayAdapter = context?.let { ArrayAdapter(it, R.layout.dropdown_item, goal) }
        autoCompleteTextView.setAdapter(arrayAdapter)
        val mSpannableString = SpannableString(resources.getText(R.string.user_agreement2))
        mSpannableString.setSpan(UnderlineSpan(), 0, mSpannableString.length, 0)
        binding.userAgreement.text=mSpannableString
    }
}