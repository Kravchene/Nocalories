package com.example.nocalories.ui.activity.mainBlock.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isNotEmpty
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentAddWaterBinding
import com.example.nocalories.ui.viewModel.UserMetricsViewModel
import com.pawegio.kandroid.defaultSharedPreferences
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddWater : Fragment() {
    lateinit var binding: FragmentAddWaterBinding
    private val userMetricsViewModel: UserMetricsViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddWaterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            add250.setOnClickListener {
                addWater(0.25)
                transition()
            }
            add500.setOnClickListener {
                addWater(0.5)
                transition()
            }
            add1000.setOnClickListener {
                addWater(1.0)
                transition()
            }

                add.setOnClickListener {
                    if (waterEditText.text!!.isNotEmpty()) {
                    addWater(waterEditText.text.toString().toDouble())
                    transition()
                }
            }
            waterAdvice.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(resources.getString(R.string.link_water))
                    )
                )

            }
        }
    }

    private fun addWater(double: Double) {
        val prefs = requireActivity().defaultSharedPreferences
        val number=prefs.getFloat("Water" ,0.0f)
        userMetricsViewModel.updateWaterDay(
            1, double+number)
    }

    fun transition(){
        findNavController().navigate(R.id.action_addWater2_to_nav_home)
    }
}