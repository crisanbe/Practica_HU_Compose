package com.sistecredito.auth.practice.data.remote

import com.sistecredito.auth.character.data.remote.dto.DataDto
import com.sistecredito.auth.login.data.remote.dto.LoginDto
import com.sistecredito.auth.login.data.remote.dto.TokenDto
import com.sistecredito.auth.practice.data.remote.dto.ListaClienteDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface ListaClienteApi {
    @GET("account/login")
    suspend fun doListaCliente(@Body lista: ListaClienteDto)
}