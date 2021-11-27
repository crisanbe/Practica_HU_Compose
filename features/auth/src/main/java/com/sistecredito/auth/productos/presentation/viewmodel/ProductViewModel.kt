package com.sistecredito.auth.productos.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sistecredito.auth.practice.domain.usecase.CustomerUseCase
import com.sistecredito.auth.practice.presentation.viewmodel.CustomerState
import com.sistecredito.auth.productos.domain.usecase.ProductUseCase
import com.sistecredito.shared.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productUseCase: ProductUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(ProductState())
    val state: State<ProductState> = _state

    init {
        doProduct()
    }


    private fun doProduct() {

        productUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ProductState(data = result.data?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        ProductState(error = result.message ?: "An unexpected error ocurred")
                }
                is Resource.Loading -> {
                    _state.value = ProductState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}