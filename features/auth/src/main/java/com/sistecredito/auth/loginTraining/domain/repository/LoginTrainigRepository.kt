package com.sistecredito.auth.loginTraining.domain.repository

import com.sistecredito.auth.loginTraining.data.remote.dto.LoginDto
import com.sistecredito.auth.loginTraining.data.remote.dto.TokenDto

interface LoginTrainigRepository {
    suspend fun login(login: LoginDto): TokenDto
}