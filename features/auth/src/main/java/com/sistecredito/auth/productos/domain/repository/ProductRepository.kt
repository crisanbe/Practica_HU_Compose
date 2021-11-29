package com.sistecredito.auth.productos.domain.repository



import com.sistecredito.auth.productos.data.remote.dto.ProductDto
import com.sistecredito.auth.productos.data.remote.dto.ResultDto


interface ProductRepository {
    suspend fun doProduct(): ProductDto
}