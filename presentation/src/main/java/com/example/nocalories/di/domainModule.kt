package com.example.nocalories.di

import com.example.damain.usecases.authorization.LoginUserUseCase
import com.example.damain.usecases.authorization.RegistrationUserUseCase
import com.example.damain.usecases.user.GetAllUserUseCase
import com.example.damain.usecases.user.GetFlowUserUseCase
import com.example.damain.usecases.user.InsertUserUseCase
import com.example.damain.usecases.user.UpdateAgeUserUseCase
import com.example.damain.usecases.user.UpdateGenderUserUseCase
import com.example.damain.usecases.user.UpdateGoalUserUseCase
import com.example.damain.usecases.user.UpdateHeightUserUseCase
import com.example.damain.usecases.user.UpdateWeightUserUseCase
import com.example.damain.usecases.userMetrics.GetAllUserMetricsUseCase
import com.example.damain.usecases.userMetrics.GetFlowUserMetricsUseCase
import com.example.damain.usecases.userMetrics.InsertUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateActivityDayUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateCaloriesDayUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateCarbohydratesDayUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateFatsDayUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateFiberDayUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateSquirrelsDayUserMetricsUseCase
import com.example.damain.usecases.userMetrics.UpdateWaterDayUserMetricsUseCase
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
    factory<UpdateWeightUserUseCase> {
        UpdateWeightUserUseCase(
            userRepository = get()
        )
    }
    factory<UpdateAgeUserUseCase> {
        UpdateAgeUserUseCase(
            userRepository = get()
        )
    }
    factory<UpdateGenderUserUseCase> {
        UpdateGenderUserUseCase(
            userRepository = get()
        )
    }
    factory<UpdateGoalUserUseCase> {
        UpdateGoalUserUseCase(
            userRepository = get()
        )
    }
    factory<UpdateHeightUserUseCase> {
        UpdateHeightUserUseCase(
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
    factory<UpdateCaloriesDayUserMetricsUseCase> {
        UpdateCaloriesDayUserMetricsUseCase(
            userMetricsRepository = get()
        )
    }
    factory<UpdateCarbohydratesDayUserMetricsUseCase> {
        UpdateCarbohydratesDayUserMetricsUseCase(
            userMetricsRepository = get()
        )
    }
    factory<UpdateFatsDayUserMetricsUseCase> {
        UpdateFatsDayUserMetricsUseCase(
            userMetricsRepository = get()
        )
    }
    factory<UpdateFiberDayUserMetricsUseCase> {
        UpdateFiberDayUserMetricsUseCase(
            userMetricsRepository = get()
        )
    }
    factory<UpdateSquirrelsDayUserMetricsUseCase> {
        UpdateSquirrelsDayUserMetricsUseCase(
            userMetricsRepository = get()
        )
    }
    factory<UpdateWaterDayUserMetricsUseCase> {
        UpdateWaterDayUserMetricsUseCase(
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