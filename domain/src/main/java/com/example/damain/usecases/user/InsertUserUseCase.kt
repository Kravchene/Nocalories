package com.example.damain.usecases.user

import com.example.damain.models.User
import com.example.damain.repository.UserRepository

class InsertUserUseCase (private val userRepository: UserRepository) {

    suspend fun execute(user: User) {
        return userRepository.insertUser(user)
    }
}