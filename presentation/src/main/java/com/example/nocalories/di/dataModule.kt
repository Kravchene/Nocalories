package com.example.nocalories.di

import com.example.damain.repository.AuthorizationRepository
import com.example.data.network.repository.AuthorizationRepositoryImpl
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.dsl.module

val dataModule = module {
    single<AuthorizationRepository> {
        AuthorizationRepositoryImpl(
            firebaseAuth = Firebase.auth
        )
    }
}