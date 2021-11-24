package com.sistecredito.auth.loginTraining.presentation.viewModel

import com.sistecredito.auth.loginTraining.data.remote.dto.TokenDto

data class LoginState(
    val isLoading: Boolean = false,
    val token: TokenDto? = null,
    val error: String = ""
)
