package com.example.nocalories.ui.activity.mainBlock.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentFoodBinding
import com.example.nocalories.ui.viewModel.MealViewModel
import com.example.nocalories.ui.viewModel.UserMetricsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Food : Fragment() {
    lateinit var binding: FragmentFoodBinding
    private lateinit var viewModel: MealViewModel
    private val userMetricsViewModel: UserMetricsViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MealViewModel::class.java]
        val meal = viewModel.getMyData()
        with(binding) {
            if (meal != null) {
                Glide.with(image.context).load(meal.photo).placeholder(R.drawable.bez_fona_3)
                    .error(R.drawable.bez_fona_3).into(image)
                food.text = meal.name
                squirrels.text = meal.squirrels.toString()
                fats.text = meal.fats.toString()
                fiber.text = meal.fiber.toString()
                calories.text = meal.calories.toString()
            }
            val caloriesValue=calories.text.toString().toInt()
            val fiberValue=fiber.text.toString().toDouble()
            val fatsValue=fats.text.toString().toDouble()
            val carbohydratesValue=carbohydrates.text.toString().toDouble()
            val squirrelsValue=squirrels.text.toString().toDouble()
            buttonAdd.setOnClickListener {
                if (minEditText.text!!.isEmpty()) {
                    Toast.makeText(context, "Поле пустое", Toast.LENGTH_SHORT).show()
                } else {
                    val portion = minEditText.text.toString().toInt()
                    userMetricsViewModel.updateCaloriesDay(1, calculation(caloriesValue.toDouble(),portion).toInt())
                    userMetricsViewModel.updateFatsDay(1, calculation(fatsValue,portion))
                    userMetricsViewModel.updateCarbohydratesDay(1,calculation(carbohydratesValue,portion))
                    userMetricsViewModel.updateFiberDay(1,calculation(fiberValue,portion) )
                    userMetricsViewModel.updateSquirrelsDay(1, calculation(squirrelsValue,portion))
                    findNavController().navigate(R.id.action_food2_to_nav_home)
                }
            }
        }
    }

    private fun calculation(a:Double,b:Int): Double {
        return (a*b)/100
    }
}
