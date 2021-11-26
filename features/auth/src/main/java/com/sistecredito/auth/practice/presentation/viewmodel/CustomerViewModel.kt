package com.sistecredito.auth.practice.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sistecredito.auth.login.presentation.viewmodel.LoginState
import com.sistecredito.auth.practice.domain.usecase.CustomerUseCase
import com.sistecredito.shared.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(private val customerUseCase: CustomerUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(CustomerState())
    val state: State<CustomerState> = _state

    init {
       doCustomer()
    }


    private fun doCustomer() {

        customerUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CustomerState(data = result.data?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        CustomerState(error = result.message ?: "An unexpected error ocurred")
                }
                is Resource.Loading -> {
                    _state.value = CustomerState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}