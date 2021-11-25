package com.sistecredito.auth.login.presentation.viewmodel

import com.sistecredito.auth.login.data.remote.dto.TokenDto

data class ListaClienteState (
    val isLoading : Boolean = false,
    val token: TokenDto? = null,
    val error: String = ""
)