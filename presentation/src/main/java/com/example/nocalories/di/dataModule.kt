package com.example.nocalories.di

import com.example.damain.repository.AuthorizationRepository
import com.example.damain.repository.UserMetricsRepository
import com.example.damain.repository.UserRepository
import com.example.data.Local.User.repository.UserMetricsRepositoryImpl
import com.example.data.Local.User.repository.UserRepositoryImpl
import com.example.data.network.repository.AuthorizationRepositoryImpl
import com.example.nocalories.MysApp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<AuthorizationRepository> {
        AuthorizationRepositoryImpl(
            firebaseAuth = Firebase.auth
        )
    }
    single<UserRepository> {
        UserRepositoryImpl(
            userDao = MysApp.INSTANCE.database.userDao(),
        )
    }
    single<UserMetricsRepository> {
        UserMetricsRepositoryImpl(
            userMetricsDao = MysApp.INSTANCE.databaseUserMetrics.userMetricsDao()
        )
    }
}
