package com.sistecredito.auth.productos.presentation.viewmodel


import com.sistecredito.auth.productos.data.remote.dto.ProductDto

data class ProductState (
    val isLoading : Boolean = false,
    val data: List<ProductDto?> = emptyList(),
    val error: String = ""
)