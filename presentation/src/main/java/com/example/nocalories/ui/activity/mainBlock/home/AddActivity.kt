package com.example.nocalories.ui.activity.mainBlock.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.damain.logic.ActivityLogic.Companion.activityLogic
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentAddActivityBinding
import com.example.nocalories.ui.viewModel.ActivityViewModel
import com.example.nocalories.ui.viewModel.UserMetricsViewModel
import com.pawegio.kandroid.defaultSharedPreferences
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
        val prefs = requireActivity().defaultSharedPreferences
        val numberActivity = prefs.getInt("activity", 0)
        viewModel = ViewModelProvider(requireActivity())[ActivityViewModel::class.java]
        val userActivity = viewModel.getMyData()

        with(binding) {
            if (userActivity != null) {
                image.setImageResource(userActivity.photo)
                activity.text = userActivity.name

            }
        }
        with(binding) {
            buttonAdd.setOnClickListener {
                if (minEditText.text!!.isNotEmpty()) {
                    val number = binding.minEditText.text.toString().toInt()

                    val functionNumber = viewModel.getMyData()!!.functionNumber

                    val as1 = numberActivity + activityLogic(functionNumber, number)

                    userMetricsViewModel.updateActivityDay(1, as1)

                    findNavController().navigate(R.id.action_addActivity_to_nav_home)
                } else {
                    Toast.makeText(context, "Поле пустое", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}


