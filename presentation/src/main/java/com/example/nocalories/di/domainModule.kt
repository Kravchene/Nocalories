package com.example.nocalories.di

import com.example.damain.usecases.authorization.LoginUserUseCase
import com.example.damain.usecases.authorization.RegistrationUserUseCase
import com.example.damain.usecases.user.GetAllUserUseCase
import com.example.damain.usecases.user.GetFlowUserUseCase
import com.example.damain.usecases.user.InsertUserUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<InsertUserUseCase> {
        InsertUserUseCase(
            userRepository = get()
        )
    }

    factory<GetAllUserUseCase> {
        GetAllUserUseCase(
            userRepository = get()
        )
    }

    factory<GetFlowUserUseCase> {
        GetFlowUserUseCase(
            userRepository = get()
        )
    }

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