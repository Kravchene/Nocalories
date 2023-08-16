package com.example.damain.usecases.userMetrics

import com.example.damain.repository.UserMetricsRepository

class UpdateCarbohydratesDayUserMetricsUseCase (private val userMetricsRepository: UserMetricsRepository) {
    suspend fun execute(id :Int,carbohydrates:Double) {
        return userMetricsRepository.updateCarbohydratesDay(id,carbohydrates)
    }

}