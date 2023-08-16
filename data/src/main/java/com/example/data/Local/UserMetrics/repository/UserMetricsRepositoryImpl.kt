package com.example.data.Local.User.repository

import com.example.damain.models.UserMetrics
import com.example.damain.repository.UserMetricsRepository
import com.example.data.Local.User.dao.UserMetricsDao
import com.example.data.Local.User.model.UserMetricsModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class UserMetricsRepositoryImpl(
    private val userMetricsDao: UserMetricsDao
) : UserMetricsRepository {

    private val job = SupervisorJob()
    private val userMetricsScope = CoroutineScope(job + Dispatchers.IO)

    override suspend fun insertUserMetrics(userMetrics: UserMetrics) {
        userMetricsScope.launch {
            userMetricsDao.insert(UserMetricsModel.map(userMetrics))
        }
    }

    override suspend fun getAllUserMetrics(): List<UserMetrics> {
        return userMetricsScope.async {
            userMetricsDao.getAll().map { it.toUser() }
        }.await()
    }

    override suspend fun updateCaloriesDay(id: Int, caloriesDay: Int) {
        userMetricsScope.launch {
            userMetricsDao.updateCaloriesDay(id, caloriesDay)
        }
    }

    override suspend fun updateActivityDay(id: Int, activityDay: Int) {
        userMetricsScope.launch {
            userMetricsDao.updateActivityDay(id, activityDay)
        }
    }

    override suspend fun updateWaterDay(id: Int, waterDay: Double) {
        userMetricsScope.launch {
            userMetricsDao.updateWaterDay(id, waterDay)
        }
    }

    override suspend fun updateSquirrelsDay(id: Int, squirrelsDay: Double) {
        userMetricsScope.launch {
            userMetricsDao.updateSquirrelsDay(id, squirrelsDay)
        }
    }

    override suspend fun updateCarbohydratesDay(id: Int, carbohydratesDay: Double) {
        userMetricsScope.launch {
            userMetricsDao.updateCarbohydratesDay(id, carbohydratesDay)
        }
    }

    override suspend fun updateFatsDay(id: Int, fatsDay: Double) {
        userMetricsScope.launch {
            userMetricsDao.updateFatsDay(id, fatsDay)
        }
    }

    override suspend fun updateFiberDay(id: Int, fiberDay: Double) {
        userMetricsScope.launch {
            userMetricsDao.updateFiberDay(id, fiberDay)
        }
    }

    override fun getAllUserMetricsFlow(): Flow<List<UserMetrics>> {
        return userMetricsDao.getAllFlow().flatMapConcat { list ->
            flowOf(list.map { it.toUser() })
        }
    }

}