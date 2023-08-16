package com.example.damain.usecases.user

import com.example.damain.repository.UserRepository

class UpdateAgeUserUseCase (private val userRepository: UserRepository) {

    suspend fun execute(id: Int ,aga: Int) {
        return userRepository.updateAge(id,aga)
    }
}