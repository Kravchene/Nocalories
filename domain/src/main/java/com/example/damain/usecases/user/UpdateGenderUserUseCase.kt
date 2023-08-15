package com.example.damain.usecases.user

import com.example.damain.repository.UserRepository

class UpdateGenderUserUseCase (private val userRepository: UserRepository) {

    suspend fun execute(id: Int ,gender: Int) {
        return userRepository.updateGender(id,gender)
    }
}