package com.example.damain.usecases.user

import com.example.damain.repository.UserRepository

class UpdateHeightUserUseCase(private val userRepository: UserRepository) {

    suspend fun execute(id: Int ,height: Int) {
        return userRepository.updateHeight(id,height)
    }
}