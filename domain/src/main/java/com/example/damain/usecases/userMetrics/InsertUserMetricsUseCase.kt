package com.example.damain.usecases.userMetrics

import com.example.damain.models.User
import com.example.damain.models.UserMetrics
import com.example.damain.repository.UserMetricsRepository

class InsertUserMetricsUseCase (private val userMetricsRepository: UserMetricsRepository) {

    suspend fun execute(userMetrics: UserMetrics) {
        return userMetricsRepository.insertUserMetrics(userMetrics)
    }
}