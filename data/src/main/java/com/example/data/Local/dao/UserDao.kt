package com.example.data.Local.dao

import kotlinx.coroutines.flow.Flow
import androidx.room.*

import com.example.data.Local.model.UserModel

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<UserModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userModel: UserModel)

    @Query("DELETE FROM user")
    fun deleteAllUser()

    @Query("UPDATE user SET weight = :newGender WHERE id = :id")
    fun updateGender(id: Int, newGender: Int)

    @Query("UPDATE user SET weight = :newGoal WHERE id = :id")
    fun updateGoal(id: Int, newGoal: Int)

    @Query("UPDATE user SET weight = :newAge WHERE id = :id")
    fun updateAge(id: Int, newAge: Int)

    @Query("UPDATE user SET weight = :newWeight WHERE id = :id")
    fun updateWeight(id: Int, newWeight: Double)

    @Query("UPDATE user SET weight = :newHeight WHERE id = :id")
    fun updateHeight(id: Int, newHeight: Int)

    @Query("SELECT * FROM user")
    fun getAllFlow(): Flow<List<UserModel>>
}