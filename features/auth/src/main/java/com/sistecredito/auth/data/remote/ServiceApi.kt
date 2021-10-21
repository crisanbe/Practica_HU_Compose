package com.sistecredito.auth.data.remote

import com.sistecredito.auth.data.remote.dto.DataDto
import retrofit2.http.GET

interface ServiceApi {

    @GET("character")
    suspend fun getAll(): DataDto
}