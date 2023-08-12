package com.example.data.Local.User.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.damain.models.User

@Entity(
    tableName = "user"
)
data class UserModel(
    val name: String,
    val gender: Int,
    val goal: Int,
    val age: Int,
    val weight: Double,
    val height: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
) {
    fun toUser(): User = User(
        name,
        gender,
        goal,
        age,
        weight,
        height

    )
    companion object {
        fun map(user: User): UserModel = UserModel(user.name, user.gender, user.goal, user.age, user.weight, user.height)
    }
}

