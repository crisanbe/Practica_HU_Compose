package com.sistecredito.auth.character.data.remote

import com.sistecredito.auth.character.data.remote.dto.DataDto
import retrofit2.http.GET

interface ServiceApi {

    @GET("character")
    suspend fun getAll(): DataDto
}