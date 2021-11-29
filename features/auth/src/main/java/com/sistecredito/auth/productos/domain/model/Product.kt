package com.sistecredito.auth.productos.domain.model

import com.sistecredito.auth.productos.data.remote.dto.ResultDto

data class Product(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<ResultDto>
)