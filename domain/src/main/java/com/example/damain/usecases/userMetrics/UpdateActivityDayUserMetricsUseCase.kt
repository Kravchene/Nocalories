package com.example.damain.usecases.userMetrics

import com.example.damain.models.UserMetrics
import com.example.damain.repository.UserMetricsRepository

class UpdateActivityDayUserMetricsUseCase(private val userMetricsRepository: UserMetricsRepository) {
    suspend fun execute(id :Int,activityDay:Int) {
        return userMetricsRepository.updateActivityDay(id,activityDay)
    }

}