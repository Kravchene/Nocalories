package com.example.damain.usecases.authorization

import com.example.damain.models.Status
import com.example.damain.models.UserCreds
import com.example.damain.repository.AuthorizationRepository

class RegistrationUserUseCase(private val authorizationRepository: AuthorizationRepository) {
    suspend fun execute(userCreds: UserCreds): Status {
        return authorizationRepository.registration(userCreds)
    }
}