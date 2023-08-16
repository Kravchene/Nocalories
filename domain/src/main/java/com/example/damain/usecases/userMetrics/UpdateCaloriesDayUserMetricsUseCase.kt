package com.example.damain.usecases.userMetrics

import com.example.damain.repository.UserMetricsRepository

class UpdateCaloriesDayUserMetricsUseCase (private val userMetricsRepository: UserMetricsRepository) {
    suspend fun execute(id :Int,caloriesDay:Int) {
        return userMetricsRepository.updateCaloriesDay(id,caloriesDay)
    }

}