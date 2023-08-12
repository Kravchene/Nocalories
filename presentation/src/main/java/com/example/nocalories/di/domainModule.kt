package com.example.nocalories.di

import com.example.damain.usecases.authorization.LoginUserUseCase
import com.example.damain.usecases.authorization.RegistrationUserUseCase
import com.example.damain.usecases.user.GetAllUserUseCase
import com.example.damain.usecases.user.GetFlowUserUseCase
import com.example.damain.usecases.user.InsertUserUseCase
import com.example.damain.usecases.userMetrics.GetAllUserMetricsUseCase
import com.example.damain.usecases.userMetrics.GetFlowUserMetricsUseCase
import com.example.damain.usecases.userMetrics.InsertUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateActivityDayUserMetricsUseCase
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

    factory<InsertUserMetricsUseCase> {
        InsertUserMetricsUseCase(
            userMetricsRepository = get()
        )
    }
    factory<GetAllUserMetricsUseCase> {
        GetAllUserMetricsUseCase(
            userMetricsRepository = get()
        )
    }
    factory<GetFlowUserMetricsUseCase> {
        GetFlowUserMetricsUseCase(
            userMetricsRepository = get()
        )
    }
    factory<UpdateActivityDayUserMetricsUseCase> {
        UpdateActivityDayUserMetricsUseCase(
            userMetricsRepository = get()
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