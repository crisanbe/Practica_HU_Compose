package com.sistecredito.auth.serie.presentation.viewmodel


import com.sistecredito.auth.productos.data.remote.dto.ProductDto
import com.sistecredito.auth.productos.data.remote.dto.ResultDto
import com.sistecredito.auth.serie.data.remote.dto.ResultsDto

data class SerieState(
    val isLoading: Boolean = false,
    val data: List<ResultsDto>? = null,
    val error: String = ""
)