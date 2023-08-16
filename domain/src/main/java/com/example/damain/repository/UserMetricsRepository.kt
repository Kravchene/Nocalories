package com.example.damain.repository


import com.example.damain.models.UserMetrics
import kotlinx.coroutines.flow.Flow

interface UserMetricsRepository {
    suspend fun insertUserMetrics(userMetrics: UserMetrics)
    suspend fun getAllUserMetrics(): List<UserMetrics>
    suspend fun updateCaloriesDay(id: Int,caloriesDay:Int)
    suspend fun updateActivityDay(id: Int,activityDay:Int)
    suspend fun updateWaterDay(id: Int,waterDay: Double)
    suspend fun updateSquirrelsDay(id: Int,squirrelsDay:Double)
    suspend fun updateCarbohydratesDay(id: Int,carbohydratesDay:Double)
    suspend fun updateFatsDay(id: Int,fatsDay:Double)
    suspend fun updateFiberDay(id: Int,fiberDay:Double)
    fun getAllUserMetricsFlow(): Flow<List<UserMetrics>>

}