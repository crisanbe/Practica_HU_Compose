package com.sistecredito.auth.character.presentation

import androidx.annotation.Keep
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sistecredito.auth.character.domain.usecase.GetAllUseCase
import com.sistecredito.shared.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@Keep
@HiltViewModel
class DataViewModel @Inject constructor(private val getAllUseCase: GetAllUseCase) : ViewModel() {
    private val _state = mutableStateOf<DataState>(DataState())
    val state: State<DataState> = _state

    init {
        getAll()
    }

    private fun getAll(){
        getAllUseCase().onEach {
                result ->
            when(result){
                is Resource.Success -> {
                    _state.value = DataState( data =  result.data)
                }
                is Resource.Error-> {
                    _state.value = DataState(error = result.message?: "An unexpected error ocurred")
                }
                is Resource.Loading -> {
                    _state.value = DataState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}
