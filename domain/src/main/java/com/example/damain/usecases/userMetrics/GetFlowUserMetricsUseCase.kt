package com.example.damain.usecases.userMetrics

import com.example.damain.models.User
import com.example.damain.models.UserMetrics
import com.example.damain.repository.UserMetricsRepository
import com.example.damain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetFlowUserMetricsUseCase (private val userMetricsRepository: UserMetricsRepository) {

    fun execute(): Flow<List<UserMetrics>> {
        return userMetricsRepository.getAllUserMetricsFlow()
    }

}