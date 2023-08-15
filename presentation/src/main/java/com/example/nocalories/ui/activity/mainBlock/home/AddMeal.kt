package com.example.nocalories.ui.activity.mainBlock.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.damain.logic.LogicWater.Companion.waterFine
import com.example.damain.logic.LogicWater.Companion.waterForWeightLoss
import com.example.damain.logic.NutrientsLogicMaintainingWeight.Companion.logicCarbohydrates
import com.example.damain.logic.NutrientsLogicMaintainingWeight.Companion.logicFats
import com.example.damain.logic.NutrientsLogicMaintainingWeight.Companion.logicFiber
import com.example.damain.logic.NutrientsLogicMaintainingWeight.Companion.squirrelLogic
import com.example.damain.logic.NutrientsLogicWeightLoss.Companion.logicCarbohydratesLoss
import com.example.damain.logic.NutrientsLogicWeightLoss.Companion.logicFatsLoss
import com.example.damain.logic.NutrientsLogicWeightLoss.Companion.logicFiberLoss
import com.example.damain.logic.NutrientsLogicWeightLoss.Companion.squirrelLogicLoss
import com.example.damain.logic.TheLogicOfCountingCalories.Companion.logicForWeightGain
import com.example.damain.logic.TheLogicOfCountingCalories.Companion.logicForWeightLoss
import com.example.damain.logic.TheLogicOfCountingCalories.Companion.maintainingWeight
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentAddAMealBinding
import com.example.nocalories.ui.viewModel.UserMetricsViewModel
import com.example.nocalories.ui.viewModel.UserViewModel
import com.pawegio.kandroid.defaultSharedPreferences
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddMeal : Fragment() {
    lateinit var binding: FragmentAddAMealBinding
    private val userModel: UserViewModel by viewModel()
    private val userMetricsViewModel: UserMetricsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddAMealBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefs = requireActivity().defaultSharedPreferences
        lifecycleScope.launch {
            userMetricsViewModel.userMetrics.collectLatest { userMetrics ->
                if (userMetrics.isNotEmpty()) {
                    with(binding) {

                        intakeOfCalories2.text = userMetrics.last().caloriesDay.toString()
                        activitDay.text = userMetrics.last().activityDay.toString()
                        waterDay.text = userMetrics.last().waterDay.toString()
                        caloriesStart.text = userMetrics.last().caloriesDay.toString()
                        SquirrelsStart.text = userMetrics.last().squirrelsDay.toString()
                        CarbohydratesStart.text = userMetrics.last().carbohydratesDay.toString()
                        FatsStart.text = userMetrics.last().fatsDay.toString()
                        FiberStart.text = userMetrics.last().fiberDay.toString()
                    }
                }
            }
        }
        lifecycleScope.launch {
            userModel.user.collectLatest { user ->
                if (user.isNotEmpty()) {
                    val gender = user.last().gender
                    val age = user.last().age
                    val weight = user.last().weight
                    val height = user.last().height
                    val goal = user.last().goal
                    when (goal) {
                        0 -> {
                            val calories = maintainingWeight(gender, age, weight, height)
                            with(binding) {
                                val calories1=calories+activitDay.text.toString().toInt()
                                currentWeight.text = weight.toString()
                                caloriesEnd.text = calories1.toString()
                                squirrelsEnd.text = squirrelLogic(calories).toString()
                                carbohydratesEnd.text = logicCarbohydrates(calories).toString()
                                fatsEnd.text = logicFats(calories).toString()
                                fiberEnd.text = logicFiber(calories).toString()
                                water.text = waterFine(weight).toString()

                            }
                        }

                        1 -> {
                            val calories = logicForWeightLoss(gender, age, weight, height)
                            with(binding) {
                                val calories1=calories+activitDay.text.toString().toInt()
                                currentWeight.text = weight.toString()
                                caloriesEnd.text = calories1.toString()
                                squirrelsEnd.text = squirrelLogicLoss(calories).toString()
                                carbohydratesEnd.text = logicCarbohydratesLoss(calories).toString()
                                fatsEnd.text = logicFatsLoss(calories).toString()
                                fiberEnd.text = logicFiberLoss(calories).toString()
                                water.text = waterForWeightLoss(weight).toString()

                            }
                        }

                        2 -> {
                            val calories = logicForWeightGain(gender, age, weight, height)
                            with(binding) {
                                val calories1=calories+activitDay.text.toString().toInt()
                                currentWeight.text = weight.toString()
                                caloriesEnd.text = calories1.toString()
                                squirrelsEnd.text = squirrelLogic(calories).toString()
                                carbohydratesEnd.text = logicCarbohydrates(calories).toString()
                                fatsEnd.text = logicFats(calories).toString()
                                fiberEnd.text = logicFiber(calories).toString()
                                water.text = waterFine(weight).toString()

                            }
                        }
                    }
                }
            }
        }
        with(binding) {

            addWater.setOnClickListener {
                findNavController().navigate(R.id.action_nav_home_to_addWater2)
                prefs.edit {
                    putFloat("Water", binding.waterDay.text.toString().toFloat())
                }
            }
            add1.setOnClickListener {
                prefs.edit {
                    putInt("activity", binding.activitDay.text.toString().toInt())
                }
                findNavController().navigate(R.id.action_nav_home_to_userActivityPerDay)
            }
            add4.setOnClickListener {
                findNavController().navigate(R.id.action_nav_home_to_updateWeight)
            }
            add2.setOnClickListener {
                findNavController().navigate(R.id.action_nav_home_to_foodCatalog)
            }
        }
    }
}

