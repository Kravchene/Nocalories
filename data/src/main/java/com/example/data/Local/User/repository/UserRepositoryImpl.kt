package com.example.data.Local.User.repository

import com.example.damain.models.User
import com.example.damain.repository.UserRepository
import com.example.data.Local.User.dao.UserDao
import com.example.data.Local.User.model.UserModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserRepositoryImpl (
    private val userDao: UserDao
    ): UserRepository {

    private val job = SupervisorJob()
    private val userScope = CoroutineScope(job + Dispatchers.IO)

    override suspend fun insertUser(user: User) {
        userScope.launch {
            userDao.insert(UserModel.map(user))
        }
    }

    override suspend fun getAllUser(): List<User> {
         return userScope.async {
            userDao.getAll().map { it.toUser() }
        }.await()
    }

    override suspend fun updateGender(id: Int, gender: Int) {
        userScope.launch {
            userDao.updateGender(id, gender)
        }
    }

    override suspend fun updateGoal(id: Int, goal: Int) {
        userScope.launch {
            userDao.updateGoal(id, goal)
        }
    }

    override suspend fun updateAge(id: Int, age: Int) {
        userScope.launch {
            userDao.updateAge(id, age)
        }
    }

    override suspend fun updateWeight(id: Int, weight: Double) {
        userScope.launch {
            userDao.updateWeight(id, weight)
        }
    }

    override suspend fun updateHeight(id: Int, height: Int) {
        userScope.launch {
            userDao.updateHeight(id, height)
        }
    }

    override suspend fun deleteAllUser() {
        userScope.launch {
            userDao.deleteAllUser()
        }
    }

    override fun getAllUserFlow(): Flow<List<User>> {
        return userDao.getAllFlow().flatMapConcat { list ->
            flowOf(list.map { it.toUser() })
        }
    }
}