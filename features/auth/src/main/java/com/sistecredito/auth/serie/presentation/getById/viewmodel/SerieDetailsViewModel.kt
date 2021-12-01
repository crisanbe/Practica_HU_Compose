package com.sistecredito.auth.serie.presentation.getById.viewmodel


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sistecredito.auth.serie.domain.usecase.GetEpisodeUseCase
import com.sistecredito.auth.serie.domain.usecase.SerieUseCase
import com.sistecredito.auth.serie.presentation.getAll.viewmodel.SerieState
import com.sistecredito.shared.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SerieDetailsViewModel @Inject constructor(
    private val getEpisodeUseCase: GetEpisodeUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(EpisodeState())
    val state: State<EpisodeState> = _state

    init {
        savedStateHandle.get<String>("serieId")?.let { id ->
            getEpisode(id)

        }
    }

    fun getEpisode(id :String){
        getEpisodeUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = EpisodeState(data = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        EpisodeState(error = result.message ?: "An unexpected error ocurred")
                }
                is Resource.Loading -> {
                    _state.value = EpisodeState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)

    }

}