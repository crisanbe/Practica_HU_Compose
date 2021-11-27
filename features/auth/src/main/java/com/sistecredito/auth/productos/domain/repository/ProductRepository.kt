package com.sistecredito.auth.productos.domain.repository



import com.sistecredito.auth.productos.data.remote.dto.ProductDto


interface ProductRepository {
    suspend fun doProduct(): List<ProductDto>
}