package com.example.nocalories.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.damain.models.User
import com.example.damain.usecases.user.GetAllUserUseCase
import com.example.damain.usecases.user.GetFlowUserUseCase
import com.example.damain.usecases.user.InsertUserUseCase
import com.example.nocalories.ui.model.ValidateState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserViewModel(
    private val getAllUserUseCase: GetAllUserUseCase,
    private val getFlowUserUseCase: GetFlowUserUseCase,
    private val insertUserUseCase: InsertUserUseCase
) : ViewModel() {
    private val _state: MutableLiveData<ValidateState> = MutableLiveData(ValidateState.DEFAULT)
    val state: LiveData<ValidateState> = _state

    val user: StateFlow<List<User>> = getFlowUserUseCase.execute().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = listOf()
    )

    fun insertUser(
        name: String,
        gender: Int,
        goal: Int,
        age: Int,
        weight: Double,
        height: Int
    ) {
        val user = isDataValid(name, gender, goal, age, weight, height) ?: return
        viewModelScope.launch(Dispatchers.IO) {
            insertUserUseCase.execute(user)
        }
    }

    private fun isDataValid(
        name: String,
        gender: Int,
        goal: Int,
        age: Int,
        weight: Double,
        height: Int
    ): User? {
        return try {
            User(
                name = name,
                gender = gender,
                goal = goal,
                age = age,
                weight = weight,
                height = height
            ).also {
                _state.value = ValidateState.SUCCESS
            }
        } catch (e: Exception) {
            _state.value = ValidateState.FAIL
            null
        }
    }
}