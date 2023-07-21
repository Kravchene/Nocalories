package com.example.data.network.model

import com.example.damain.models.Status
import com.google.firebase.auth.AuthResult

data class NetworkResult(
    val status: Status,
    val authResult: AuthResult?
)