package com.example.damain.usecases.user

import com.example.damain.repository.UserRepository

class UpdateGoalUserUseCase(private val userRepository: UserRepository) {

    suspend fun execute(id: Int ,goal: Int) {
        return userRepository.updateGoal(id,goal)
    }
}