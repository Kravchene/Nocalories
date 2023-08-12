package com.example.damain.usecases.userMetrics

import com.example.damain.models.User
import com.example.damain.models.UserMetrics
import com.example.damain.repository.UserMetricsRepository
import com.example.damain.repository.UserRepository

class GetAllUserMetricsUseCase (private val userMetricsRepository: UserMetricsRepository) {

    suspend fun execute():List<UserMetrics> {
        return userMetricsRepository.getAllUserMetrics()
    }
}