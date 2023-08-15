package com.example.nocalories.ui.activity.mainBlock.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentChangeGenderBinding
import com.example.nocalories.databinding.FragmentChangeGoalBinding
import com.example.nocalories.ui.viewModel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChangeGoal : Fragment() {
    lateinit var binding: FragmentChangeGoalBinding
    private val userViewModel: UserViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChangeGoalBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val autoCompleteTextView: AutoCompleteTextView = binding.autoCompleteTextView
        val goal = resources.getStringArray((R.array.Goal))
        val arrayAdapter = context?.let { ArrayAdapter(it, R.layout.dropdown_item, goal) }
        autoCompleteTextView.setAdapter(arrayAdapter)
        with (binding){
            val goal = when (autoCompleteTextView.text.toString()) {
                "Быть в форме" -> 0
                "Похудеть" -> 1
                "Набрать мышечную массу" -> 2
                else -> 0
            }
            buttonSave.setOnClickListener {
                autoCompleteTextView.setAdapter(arrayAdapter)
                userViewModel.updateGoal(1,goal)
                findNavController().navigate(R.id.action_changeGoal_to_nav_pofel)
                Toast.makeText(context, autoCompleteTextView.adapter.toString(), Toast.LENGTH_SHORT).show()

            }
        }
    }

}