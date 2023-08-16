package com.example.damain.models

data class User(
    val name: String,
    val gender: Int,
    val goal: Int,
    val age: Int,
    val weight: Double,
    val height: Int,
    val id: Int = 0
)
