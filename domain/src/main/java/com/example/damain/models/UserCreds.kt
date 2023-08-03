package com.example.damain.models

data class UserCreds(
    val email: String,
    val password: String,
    val gender: Byte,
    val purpose: Byte,
    val Year: Short,
    val Weight: Short,
    val Height: Short
)
