package com.example.nocalories.di

import com.example.nocalories.ui.viewModel.AuthViewModel
import com.example.nocalories.ui.viewModel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<UserViewModel> {
        UserViewModel(
            getAllUserUseCase = get(),
            getFlowUserUseCase = get(),
            insertUserUseCase = get()
        )
    }
    viewModel<AuthViewModel> {
        AuthViewModel(
            loginUserUseCase = get(),
            registrationUserUseCase = get()
        )
    }

}