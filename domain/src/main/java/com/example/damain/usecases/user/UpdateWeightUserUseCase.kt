package com.example.damain.usecases.user

import com.example.damain.logic.NutrientsLogicMaintainingWeight
import com.example.damain.models.User
import com.example.damain.repository.UserRepository

class UpdateWeightUserUseCase(private val userRepository: UserRepository) {

    suspend fun execute(id: Int ,weight: Double) {
        return userRepository.updateWeight(id,weight)
    }
}