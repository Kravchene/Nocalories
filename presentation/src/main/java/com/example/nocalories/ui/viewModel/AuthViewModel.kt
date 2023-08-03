package com.example.nocalories.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.damain.models.LoginAndPasswordCheck
import com.example.damain.models.Status
import com.example.damain.models.UserCreds
import com.example.damain.usecases.LoginUserUseCase
import com.example.damain.usecases.RegistrationUserUseCase
import com.example.nocalories.ui.model.ValidateState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlin.Exception
import kotlin.Exception as Exception1

class AuthViewModel (
    private val loginUserUseCase: LoginUserUseCase,
    private val registrationUserUseCase: RegistrationUserUseCase
): ViewModel() {

    private val _state: MutableLiveData<ValidateState> = MutableLiveData(ValidateState.DEFAULT)
    val state: LiveData<ValidateState> = _state

    private val _authState: MutableSharedFlow<Status> = MutableSharedFlow(
        replay = 1
    )
    val authState: SharedFlow<Status> = _authState

    fun login(email: String, password: String,gender: Byte, purpose: Byte, Year: Short, Weight: Short, Height: Short) {
        val userCreds = isDataValid(email, password,gender,purpose,Year,Weight,Height) ?: return
        viewModelScope.launch(Dispatchers.IO) {
            _authState.emit(loginUserUseCase.execute(userCreds))
        }
    }

    fun signUp(email: String, password: String,gender: Byte,purpose: Byte, Year: Short, Weight: Short, Height: Short) {
        val userCreds = isDataValid(email, password,gender,purpose,Year,Weight,Height) ?: return
        viewModelScope.launch(Dispatchers.IO) {
            _authState.emit(registrationUserUseCase.execute(userCreds))
        }
    }

    private fun isDataValid(email: String, password: String , gender: Byte, purpose: Byte, Year: Short, Weight: Short, Height: Short): UserCreds? {
        return try {
            if (LoginAndPasswordCheck.check(email) && LoginAndPasswordCheck.check(password)) {
                UserCreds(
                    email = email,
                    password = password,
                    gender = gender,
                    purpose = purpose,
                    Year = Year,
                    Weight = Weight,
                    Height = Height
                ).also {
                    _state.value = ValidateState.SUCCESS
                }
                }else throw Exception()
            } catch (e: Exception) {
                _state.value = ValidateState.FAIL
                null
            }
        }
    }
