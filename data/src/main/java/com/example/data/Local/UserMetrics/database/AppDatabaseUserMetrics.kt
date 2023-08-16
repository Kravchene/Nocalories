package com.example.data.Local.User.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.Local.User.dao.UserMetricsDao
import com.example.data.Local.User.model.UserMetricsModel

@Database(
    entities = [UserMetricsModel::class],
    version = AppDatabaseUserMetrics.DATABASE_VERSION
)
abstract class AppDatabaseUserMetrics: RoomDatabase() {

    abstract fun userMetricsDao(): UserMetricsDao

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "my_UserMetrics"
        private var INSTANCE: AppDatabaseUserMetrics? = null

        fun getDatabase(
            context: Context
        ): AppDatabaseUserMetrics {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabaseUserMetrics::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}