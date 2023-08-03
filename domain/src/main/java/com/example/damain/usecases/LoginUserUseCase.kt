package com.example.damain.usecases

import com.example.damain.models.Status
import com.example.damain.models.UserCreds
import com.example.damain.repository.AuthorizationRepository

class LoginUserUseCase(private val authorizationRepository: AuthorizationRepository) {
    suspend fun execute(userCreds: UserCreds): Status {
        return authorizationRepository.login(userCreds)
    }
}