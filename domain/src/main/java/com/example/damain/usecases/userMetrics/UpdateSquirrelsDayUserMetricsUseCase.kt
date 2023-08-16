package com.example.damain.usecases.userMetrics

import com.example.damain.repository.UserMetricsRepository

class UpdateSquirrelsDayUserMetricsUseCase(private val userMetricsRepository: UserMetricsRepository) {
    suspend fun execute(id :Int,squirrels:Double) {
        return userMetricsRepository.updateSquirrelsDay(id,squirrels)
    }

}