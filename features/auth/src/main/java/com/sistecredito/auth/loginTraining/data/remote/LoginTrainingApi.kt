package com.sistecredito.auth.loginTraining.data.remote

import com.sistecredito.auth.loginTraining.data.remote.dto.LoginDto
import com.sistecredito.auth.loginTraining.data.remote.dto.TokenDto
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginTrainingApi {

    @POST("account/login")
    suspend fun login(@Body loginDto: LoginDto): TokenDto
}