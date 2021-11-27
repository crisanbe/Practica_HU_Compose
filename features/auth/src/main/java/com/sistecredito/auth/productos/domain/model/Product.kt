package com.sistecredito.auth.productos.domain.model

data class Product(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)