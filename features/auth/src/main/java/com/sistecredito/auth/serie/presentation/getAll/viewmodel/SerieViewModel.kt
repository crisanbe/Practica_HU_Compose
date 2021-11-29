package com.sistecredito.auth.serie.presentation.getAll.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sistecredito.auth.serie.domain.usecase.SerieUseCase
import com.sistecredito.shared.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SerieViewModel @Inject constructor(private val productUseCase: SerieUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(SerieState())
    val state: State<SerieState> = _state

    init {
        doSerie()
    }


    private fun doSerie() {

        productUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = SerieState(data = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        SerieState(error = result.message ?: "An unexpected error ocurred")
                }
                is Resource.Loading -> {
                    _state.value = SerieState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}