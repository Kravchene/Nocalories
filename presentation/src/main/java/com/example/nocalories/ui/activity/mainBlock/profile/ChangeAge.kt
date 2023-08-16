package com.example.nocalories.ui.activity.mainBlock.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentChangeAgeBinding
import com.example.nocalories.ui.viewModel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChangeAge : Fragment() {
    lateinit var binding: FragmentChangeAgeBinding
    private val userViewModel: UserViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChangeAgeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with (binding){
            buttonSave.setOnClickListener {
                if (ageEditText.text!!.isEmpty()) {
                    Toast.makeText(context, "Поле пустое", Toast.LENGTH_SHORT).show()
                }else{
                    userViewModel.updateAge(1, ageEditText.text.toString().toInt())
                    findNavController().navigate(R.id.action_changeAge_to_nav_pofel)
                }
            }
        }
    }

}