package com.example.damain.usecases.userMetrics

import com.example.damain.repository.UserMetricsRepository

class UpdateWaterDayUserMetricsUseCase(private val userMetricsRepository: UserMetricsRepository) {
    suspend fun execute(id :Int,water:Double) {
        return userMetricsRepository.updateWaterDay(id,water)
    }

}