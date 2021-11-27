package com.sistecredito.auth.productos.domain.usecase


import com.sistecredito.auth.practice.data.remote.dto.CustomerDto
import com.sistecredito.auth.productos.data.remote.dto.ProductDto
import com.sistecredito.auth.productos.domain.repository.ProductRepository
import com.sistecredito.shared.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

    class ProductUseCase @Inject constructor(private val repository: ProductRepository) {

    operator fun invoke(): Flow<Resource<List<ProductDto>>> = flow {
        try {
            emit(Resource.Loading<List<ProductDto>>())
            val listproduct = repository.doProduct()
            emit(Resource.Success<List<ProductDto>>(listproduct))

        } catch (e: HttpException) {
            emit(Resource.Error<List<ProductDto>>(e.localizedMessage ?: "An unexpected error ocurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<ProductDto>>("Couldn't reach server. Check you internet connection"))
        }
    }
}