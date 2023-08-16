package com.example.nocalories

import android.app.Application
import com.example.data.Local.User.database.AppDatabase
import com.example.data.Local.User.database.AppDatabaseUserMetrics
import com.example.nocalories.di.dataModule
import com.example.nocalories.di.domainModule
import com.example.nocalories.di.presentationModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class MysApp: Application() {

    val database by lazy { AppDatabase.getDatabase(this) }
    val databaseUserMetrics by lazy { AppDatabaseUserMetrics.getDatabase(this) }
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MysApp)
            androidLogger(Level.INFO)
            modules(dataModule, presentationModule, domainModule)
        }
        INSTANCE = this

    }

    companion object {
        lateinit var INSTANCE: MysApp
    }

}