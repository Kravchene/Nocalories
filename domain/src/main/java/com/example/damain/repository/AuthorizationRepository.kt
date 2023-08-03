package com.example.damain.repository

import com.example.damain.models.UserCreds
import com.example.damain.models.Status

interface AuthorizationRepository {
    suspend fun login(userCreds: UserCreds):Status
    suspend fun registration(userCreds: UserCreds):Status
}
