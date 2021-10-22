package com.sistecredito.auth.login.domain.repository

import com.sistecredito.auth.login.data.remote.dto.LoginDto
import com.sistecredito.auth.login.data.remote.dto.TokenDto


interface LoginRepository {
    suspend fun doLogin(login: LoginDto) : TokenDto
}