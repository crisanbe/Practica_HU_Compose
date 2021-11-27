package com.sistecredito.auth.productos.data.remote

import com.sistecredito.auth.productos.data.remote.dto.ProductDto
import retrofit2.http.GET

interface ProductApi {
    @GET("pokemon")
    suspend fun doProduct(): List<ProductDto>
}