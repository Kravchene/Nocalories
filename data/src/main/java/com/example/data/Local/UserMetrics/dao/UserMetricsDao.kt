package com.example.data.Local.User.dao

import kotlinx.coroutines.flow.Flow
import androidx.room.*
import com.example.data.Local.User.model.UserMetricsModel

@Dao
interface UserMetricsDao {
    @Query("SELECT * FROM userMetrics")
    fun getAll(): List<UserMetricsModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userMetricsModel: UserMetricsModel)

    @Query("UPDATE userMetrics SET caloriesDay = :newCaloriesDay WHERE id = :id")
    fun updateCaloriesDay(id: Int,newCaloriesDay : Int)

    @Query("UPDATE userMetrics SET activityDay = :newActivityDay WHERE id = :id")
    fun updateActivityDay(id: Int, newActivityDay: Int)

    @Query("UPDATE userMetrics SET waterDay = :newWaterDay WHERE id = :id")
    fun updateWaterDay(id: Int, newWaterDay: Double)

    @Query("UPDATE userMetrics SET squirrelsDay = :newSquirrelsDay WHERE id = :id")
    fun updateSquirrelsDay(id: Int, newSquirrelsDay: Double)

    @Query("UPDATE userMetrics SET carbohydratesDay = :newCarbohydratesDay WHERE id = :id")
    fun updateCarbohydratesDay(id: Int, newCarbohydratesDay: Double)

    @Query("UPDATE userMetrics SET fatsDay = :newFatsDay WHERE id = :id")
    fun updateFatsDay(id: Int, newFatsDay: Double)

    @Query("UPDATE userMetrics SET fiberDay = :newFiberDay WHERE id = :id")
    fun updateFiberDay(id: Int, newFiberDay: Double)


    @Query("SELECT * FROM userMetrics")
    fun getAllFlow(): Flow<List<UserMetricsModel>>
}