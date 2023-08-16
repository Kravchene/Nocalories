package com.example.nocalories.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.damain.models.Meal

class MealViewModel: ViewModel() {
    private var myData: Meal? = null

    fun setMyData(data: Meal) {
        myData = data
    }

    fun getMyData(): Meal? {
        return myData
    }
}