package com.sistecredito.auth.serie.data.remote

import com.sistecredito.auth.productos.data.remote.dto.ProductDto
import com.sistecredito.auth.productos.data.remote.dto.ResultDto
import com.sistecredito.auth.serie.data.remote.dto.ResultsDto
import com.sistecredito.auth.serie.data.remote.dto.SerieDto
import retrofit2.http.GET
import retrofit2.http.Path

interface SerieApi {
    @GET("episode")
    suspend fun doSerie(): SerieDto

    @GET("episode/{id}")
    suspend fun getEpisodeById(
        @Path("id") id:String
    ):ResultsDto
}