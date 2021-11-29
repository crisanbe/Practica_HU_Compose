package com.sistecredito.auth.serie.presentation.getAll.viewmodel


import com.sistecredito.auth.productos.data.remote.dto.ProductDto
import com.sistecredito.auth.productos.data.remote.dto.ResultDto
import com.sistecredito.auth.serie.data.remote.dto.ResultsDto
import com.sistecredito.auth.serie.data.remote.dto.SerieDto

data class SerieState(
    val isLoading: Boolean = false,
    val data: SerieDto? = null,
    val error: String = ""
)