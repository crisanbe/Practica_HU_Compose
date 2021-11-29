package com.sistecredito.auth.serie.data.remote

import com.sistecredito.auth.productos.data.remote.dto.ProductDto
import com.sistecredito.auth.productos.data.remote.dto.ResultDto
import com.sistecredito.auth.serie.data.remote.dto.ResultsDto
import retrofit2.http.GET

interface SerieApi {
    @GET("episode")
    suspend fun doSerie(): List<ResultsDto>
}