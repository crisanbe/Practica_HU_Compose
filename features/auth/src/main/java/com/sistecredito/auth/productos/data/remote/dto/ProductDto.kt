package com.sistecredito.auth.productos.data.remote.dto

data class ProductDto(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<ResultDto>
)