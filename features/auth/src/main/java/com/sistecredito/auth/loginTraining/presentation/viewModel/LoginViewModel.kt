package com.sistecredito.auth.loginTraining.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sistecredito.auth.loginTraining.data.remote.dto.LoginDto
import com.sistecredito.auth.loginTraining.domain.model.Login
import com.sistecredito.auth.loginTraining.domain.useCase.LoginTrainigUseCase
import com.sistecredito.shared.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginTrainigUseCase: LoginTrainigUseCase): ViewModel(){

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    init {
        doLogin(LoginDto(clientId = "mobile_customer", "123456","jmena@sistecredito.com"))
    }

    fun doLogin(login: LoginDto){

        loginTrainigUseCase(login).onEach { result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = LoginState(true)
                }
                is Resource.Error -> {
                    _state.value = LoginState(error = result.message ?: "Algo paso!")
                }
                is Resource.Success -> {
                    _state.value = LoginState(token = result.data)
                }
            }

        }.launchIn(viewModelScope)
    }
}