package com.example.nocalories.ui.activity.mainBlock.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.damain.logic.ActivityLogic.Companion.activityLogic
import com.example.damain.models.UserActivity
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentAddActivityBinding
import com.example.nocalories.ui.viewModel.ActivityViewModel
import com.example.nocalories.ui.viewModel.UserMetricsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddActivity : Fragment() {
    lateinit var binding: FragmentAddActivityBinding
    private lateinit var viewModel: ActivityViewModel
    private val userMetricsViewModel: UserMetricsViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddActivityBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ActivityViewModel::class.java]
        val userActivity = viewModel.getMyData()

        with(binding) {
            if (userActivity != null) {
                image.setImageResource(userActivity.photo)
                activity.text = userActivity.name

            }
        }

        lifecycleScope.launch {
            userMetricsViewModel.userMetrics.collectLatest { userMetrics ->
                if (userMetrics.isNotEmpty()) {
                    with(binding) {
                        if (minEditText.text!!.isNotEmpty()) {
                            val min = minEditText.text.toString().toInt()
                            activityLogic(userActivity!!.functionNumber, min)
                            lifecycleScope.launch {
                                userMetricsViewModel.updateActivityDay(userMetrics.last().id,activityLogic(userActivity.functionNumber, min))
                            }
                        }
                    }
                }
            }
        }

                with(binding) {
                    buttonAdd.setOnClickListener {
                        if (minEditText.text!!.isNotEmpty()) {
                            findNavController().navigate(R.id.nav_home)
                        }
                    }
                }
            }

    }
