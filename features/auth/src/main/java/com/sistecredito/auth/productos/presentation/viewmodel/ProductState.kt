package com.sistecredito.auth.productos.presentation.viewmodel


import com.sistecredito.auth.productos.data.remote.dto.ProductDto
import com.sistecredito.auth.productos.data.remote.dto.ResultDto

data class ProductState (
    val isLoading : Boolean = false,
    val data: ProductDto? = null,
    val error: String = ""
)