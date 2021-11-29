package com.sistecredito.auth.productos.data.remote

import com.sistecredito.auth.productos.data.remote.dto.ProductDto
import com.sistecredito.auth.productos.data.remote.dto.ResultDto
import retrofit2.http.GET

interface ProductApi {
    @GET("pokemon")
    suspend fun doProduct(): ProductDto
}