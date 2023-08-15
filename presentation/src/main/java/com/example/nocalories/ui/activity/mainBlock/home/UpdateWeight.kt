package com.example.nocalories.ui.activity.mainBlock.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentUpdateWeightBinding
import com.example.nocalories.ui.viewModel.UserMetricsViewModel
import com.example.nocalories.ui.viewModel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UpdateWeight : Fragment() {
    lateinit var binding: FragmentUpdateWeightBinding
    private val user: UserViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateWeightBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            buttonSave.setOnClickListener {
                if (weightEditText.text!!.isNotEmpty()) {
                    user.updateWeight(
                        1,
                        weightEditText.text.toString().toDouble()
                    )
                    findNavController().navigate(R.id.action_updateWeight_to_nav_home)
                } else {
                    Toast.makeText(context, "Поле пустое", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}