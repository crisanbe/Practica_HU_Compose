package com.sistecredito.auth.login.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sistecredito.auth.login.data.remote.dto.LoginDto
import com.sistecredito.auth.login.domain.usecase.LogInUseCase
import com.sistecredito.shared.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(private val logInUseCase: LogInUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    init {
        doLogin(LoginDto(clientId = "mobile_customer", "123456","jmena@sistecredito.com"))
    }


    private fun doLogin(login: LoginDto) {

        logInUseCase(login).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = LoginState(token = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        LoginState(error = result.message ?: "An unexpected error ocurred")
                }
                is Resource.Loading -> {
                    _state.value = LoginState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}