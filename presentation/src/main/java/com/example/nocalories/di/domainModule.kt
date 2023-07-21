package com.example.nocalories.di

import com.example.damain.repository.AuthorizationRepository
import com.example.damain.usecases.LoginUserUseCase
import com.example.damain.usecases.RegistrationUserUseCase
import com.example.data.network.repository.AuthorizationRepositoryImpl
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.dsl.module

val domainModule = module {
    factory<LoginUserUseCase> {
        LoginUserUseCase(
            authorizationRepository = get()
        )
    }
    factory<RegistrationUserUseCase> {
        RegistrationUserUseCase(
            authorizationRepository = get()
        )
    }
}