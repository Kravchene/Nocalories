package com.example.data.Local.User.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.damain.models.UserMetrics

@Entity(
    tableName = "userMetrics"
)
data class UserMetricsModel(
    val caloriesDay: Int,
    val activityDay: Int,
    val waterDay:Double,
    val squirrelsDay:Double,
    val carbohydratesDay:Double,
    val fatsDay:Double,
    val fiberDay:Double,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
) {
    fun toUser(): UserMetrics = UserMetrics(
        caloriesDay,
        activityDay,
        waterDay,
        squirrelsDay,
        carbohydratesDay,
        fatsDay,
        fiberDay

    )
    companion object {
        fun map(userMetrics: UserMetrics): UserMetricsModel = UserMetricsModel(
            userMetrics.caloriesDay, userMetrics.activityDay, userMetrics.waterDay, userMetrics.squirrelsDay, userMetrics.carbohydratesDay, userMetrics.fatsDay,
            userMetrics.fiberDay)
    }
}

