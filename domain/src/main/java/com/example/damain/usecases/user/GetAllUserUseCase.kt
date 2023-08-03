package com.example.damain.usecases.user

import com.example.damain.models.User
import com.example.damain.repository.UserRepository

class GetAllUserUseCase (private val userRepository: UserRepository) {

    suspend fun execute():List<User> {
        return userRepository.getAllUser()
    }
}