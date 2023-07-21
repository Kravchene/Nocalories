package com.example.nocalories.di

import com.example.damain.repository.AuthorizationRepository
import com.example.damain.usecases.LoginUserUseCase
import com.example.damain.usecases.RegistrationUserUseCase
import com.example.data.network.repository.AuthorizationRepositoryImpl
import com.example.nocalories.ui.viewModel.AuthViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<AuthViewModel> {
        AuthViewModel(
            loginUserUseCase = get(),
            registrationUserUseCase = get()
        )
    }

}