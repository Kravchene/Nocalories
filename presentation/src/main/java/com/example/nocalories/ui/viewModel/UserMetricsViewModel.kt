package com.example.nocalories.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.damain.models.UserMetrics
import com.example.damain.usecases.userMetrics.GetAllUserMetricsUseCase
import com.example.damain.usecases.userMetrics.GetFlowUserMetricsUseCase
import com.example.damain.usecases.userMetrics.InsertUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateActivityDayUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateCaloriesDayUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateCarbohydratesDayUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateFatsDayUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateFiberDayUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateSquirrelsDayUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateWaterDayUserMetricsUseCase
import com.example.nocalories.ui.model.ValidateState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class UserMetricsViewModel(
    private val getAllUserMetricsUseCase: GetAllUserMetricsUseCase,
    private val getFlowUserMetricsUseCase: GetFlowUserMetricsUseCase,
    private val insertUserMetricsUseCase: InsertUserMetricsUseCase,
    private val updateActivityDayUserMetricsUseCase: UpdateActivityDayUserMetricsUseCase,
    private val updateCaloriesDayUserMetricsUseCase: UpdateCaloriesDayUserMetricsUseCase,
    private val updateCarbohydratesDayUserMetricsUseCase: UpdateCarbohydratesDayUserMetricsUseCase,
    private val updateFatsDayUserMetricsUseCase: UpdateFatsDayUserMetricsUseCase,
    private val updateFiberDayUserMetricsUseCase: UpdateFiberDayUserMetricsUseCase,
    private val updateSquirrelsDayUserMetricsUseCase: UpdateSquirrelsDayUserMetricsUseCase,
    private val updateWaterDayUserMetricsUseCase: UpdateWaterDayUserMetricsUseCase


) : ViewModel() {
    private val _state: MutableLiveData<ValidateState> = MutableLiveData(ValidateState.DEFAULT)
    val state: LiveData<ValidateState> = _state

    val userMetrics: StateFlow<List<UserMetrics>> = getFlowUserMetricsUseCase.execute().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = listOf()
    )

    fun insertUserMetrics(
        caloriesDay: Int,
        activityDay: Int,
        waterDay: Double,
        squirrelsDay: Double,
        carbohydratesDay: Double,
        fatsDay: Double,
        fiberDay: Double

    ) {
        val userMetrics = isDataValid(
            caloriesDay,
            activityDay,
            waterDay,
            squirrelsDay,
            carbohydratesDay,
            fatsDay,
            fiberDay
        ) ?: return
        viewModelScope.launch(Dispatchers.IO) {
            insertUserMetricsUseCase.execute(userMetrics)
        }
    }

    fun updateActivityDay(id: Int, activityDay: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            updateActivityDayUserMetricsUseCase.execute(id, activityDay)
        }

    }

    fun updateCaloriesDay(id: Int, calories: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            updateCaloriesDayUserMetricsUseCase.execute(id, calories)
        }

    }

    fun updateWaterDay(id: Int, activityDay: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            updateWaterDayUserMetricsUseCase.execute(id, activityDay)
        }

    }

    fun updateSquirrelsDay(id: Int, squirrels: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            updateSquirrelsDayUserMetricsUseCase.execute(id, squirrels)
        }

    }

    fun updateCarbohydratesDay(id: Int, carbohydrates: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            updateCarbohydratesDayUserMetricsUseCase.execute(id, carbohydrates)
        }

    }

    fun updateFatsDay(id: Int, fats: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            updateFatsDayUserMetricsUseCase.execute(id, fats)
        }

    }

    fun updateFiberDay(id: Int, fiber: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            updateFiberDayUserMetricsUseCase.execute(id, fiber)
        }

    }


    private fun isDataValid(
        caloriesDay: Int,
        activityDay: Int,
        waterDay: Double,
        squirrelsDay: Double,
        carbohydratesDay: Double,
        fatsDay: Double,
        fiberDay: Double
    ): UserMetrics? {
        return try {
            UserMetrics(
                caloriesDay = caloriesDay,
                activityDay = activityDay,
                waterDay = waterDay,
                squirrelsDay = squirrelsDay,
                carbohydratesDay = carbohydratesDay,
                fatsDay = fatsDay,
                fiberDay = fiberDay
            ).also {
                _state.value = ValidateState.SUCCESS
            }
        } catch (e: Exception) {
            _state.value = ValidateState.FAIL
            null
        }
    }
}

