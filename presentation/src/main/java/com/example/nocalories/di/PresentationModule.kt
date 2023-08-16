package com.example.nocalories.di

import com.example.nocalories.ui.viewModel.AuthViewModel
import com.example.nocalories.ui.viewModel.UserMetricsViewModel
import com.example.nocalories.ui.viewModel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<UserViewModel> {
        UserViewModel(
            getAllUserUseCase = get(),
            getFlowUserUseCase = get(),
            insertUserUseCase = get(),
            updateWeightUserUseCase = get(),
            updateAgeUserUseCase = get(),
            updateGenderUserUseCase = get(),
            updateGoalUserUseCase = get(),
            updateHeightUserUseCase = get(),
        )
    }
    viewModel<AuthViewModel> {
        AuthViewModel(
            loginUserUseCase = get(),
            registrationUserUseCase = get()
        )
    }
    viewModel<UserMetricsViewModel>{
        UserMetricsViewModel(
            getAllUserMetricsUseCase = get(),
            getFlowUserMetricsUseCase = get(),
            insertUserMetricsUseCase = get(),
            updateActivityDayUserMetricsUseCase = get(),
            updateCaloriesDayUserMetricsUseCase = get(),
            updateCarbohydratesDayUserMetricsUseCase = get(),
            updateFatsDayUserMetricsUseCase = get(),
            updateFiberDayUserMetricsUseCase = get(),
            updateSquirrelsDayUserMetricsUseCase = get(),
            updateWaterDayUserMetricsUseCase = get(),
        )
    }

}