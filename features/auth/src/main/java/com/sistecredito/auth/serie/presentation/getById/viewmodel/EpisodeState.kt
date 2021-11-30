package com.sistecredito.auth.serie.presentation.getById.viewmodel


import com.sistecredito.auth.productos.data.remote.dto.ProductDto
import com.sistecredito.auth.productos.data.remote.dto.ResultDto
import com.sistecredito.auth.serie.data.remote.dto.ResultsDto
import com.sistecredito.auth.serie.data.remote.dto.SerieDto

data class EpisodeState(
    val isLoading: Boolean = false,
    val data: ResultsDto? = null,
    val error: String = ""
)