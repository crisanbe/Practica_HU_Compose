package com.sistecredito.auth.productos.data.repository



import com.sistecredito.auth.productos.data.remote.ProductApi
import com.sistecredito.auth.serie.data.remote.SerieApi
import com.sistecredito.auth.productos.data.remote.dto.ProductDto
import com.sistecredito.auth.productos.domain.repository.ProductRepository
import com.sistecredito.auth.serie.domain.repository.SerieRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val api: ProductApi): ProductRepository {
    override suspend fun doProduct(): ProductDto  {
        return  api.doProduct()
    }

}