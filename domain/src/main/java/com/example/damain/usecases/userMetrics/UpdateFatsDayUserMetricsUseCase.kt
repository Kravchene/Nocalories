package com.example.damain.usecases.userMetrics

import com.example.damain.repository.UserMetricsRepository

class UpdateFatsDayUserMetricsUseCase (private val userMetricsRepository: UserMetricsRepository) {
    suspend fun execute(id :Int,fats:Double) {
        return userMetricsRepository.updateFatsDay(id,fats)
    }

}