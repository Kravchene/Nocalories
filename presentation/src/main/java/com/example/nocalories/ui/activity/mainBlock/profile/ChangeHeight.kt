package com.example.nocalories.ui.activity.mainBlock.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentChangeGenderBinding
import com.example.nocalories.databinding.FragmentChangeHeightBinding
import com.example.nocalories.ui.viewModel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChangeHeight : Fragment() {
    lateinit var binding: FragmentChangeHeightBinding
    private val userViewModel: UserViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChangeHeightBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with (binding){
            buttonSave.setOnClickListener {
                if (heightEditText.text!!.isNotEmpty()) {
                    userViewModel.updateHeight(1, heightEditText.text.toString().toInt())
                    findNavController().navigate(R.id.action_changeHeight_to_nav_pofel)
                }
            }
        }
    }

}