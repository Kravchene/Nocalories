package com.example.data.Local.User.dao

import kotlinx.coroutines.flow.Flow
import androidx.room.*

import com.example.data.Local.User.model.UserModel

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<UserModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userModel: UserModel)

    @Query("DELETE FROM user")
    fun deleteAllUser()

    @Query("UPDATE user SET gender = :newGender WHERE id = :id")
    fun updateGender(id: Int, newGender: Int)

    @Query("UPDATE user SET goal = :newGoal WHERE id = :id")
    fun updateGoal(id: Int, newGoal: Int)

    @Query("UPDATE user SET age = :newAge WHERE id = :id")
    fun updateAge(id: Int, newAge: Int)

    @Query("UPDATE user SET weight = :newWeight WHERE id = :id")
    fun updateWeight(id: Int, newWeight: Double)

    @Query("UPDATE user SET height = :newHeight WHERE id = :id")
    fun updateHeight(id: Int, newHeight: Int)

    @Query("SELECT * FROM user")
    fun getAllFlow(): Flow<List<UserModel>>
}