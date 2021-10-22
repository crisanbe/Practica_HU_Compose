package com.sistecredito.auth.login.data.remote

import com.sistecredito.auth.character.data.remote.dto.DataDto
import com.sistecredito.auth.login.data.remote.dto.LoginDto
import com.sistecredito.auth.login.data.remote.dto.TokenDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface LoginApi {
    @POST("account/login")
    suspend fun doLogin(@Body login: LoginDto): TokenDto
}