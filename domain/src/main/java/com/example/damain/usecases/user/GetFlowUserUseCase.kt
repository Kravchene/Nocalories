package com.example.damain.usecases.user

import com.example.damain.models.User
import com.example.damain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetFlowUserUseCase (private val userRepository: UserRepository) {

    fun execute(): Flow<List<User>> {
        return userRepository.getAllUserFlow()
    }

}