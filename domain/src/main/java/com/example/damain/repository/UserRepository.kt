package com.example.damain.repository

import com.example.damain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertUser(user: User)
    suspend fun getAllUser(): List<User>
    suspend fun updateGender(id: Int,gender:Int)
    suspend fun updateGoal(id: Int,goal:Int)
    suspend fun updateAge(id: Int,age: Int)
    suspend fun updateWeight(id: Int,weight:Double)
    suspend fun updateHeight(id: Int,height:Int)
    suspend fun deleteAllUser()
    fun getAllUserFlow(): Flow<List<User>>

}