package com.example.damain.usecases.userMetrics

import com.example.damain.repository.UserMetricsRepository

class UpdateFiberDayUserMetricsUseCase(private val userMetricsRepository: UserMetricsRepository) {
    suspend fun execute(id :Int,fiber:Double) {
        return userMetricsRepository.updateFiberDay(id,fiber)
    }

}