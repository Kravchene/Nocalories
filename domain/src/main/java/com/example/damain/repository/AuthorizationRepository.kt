package com.example.damain.repository

import com.example.damain.models.Status
import com.example.damain.models.UserCreds

interface AuthorizationRepository {
    suspend fun login(userCreds: UserCreds): Status
    suspend fun registration(userCreds: UserCreds): Status
}
