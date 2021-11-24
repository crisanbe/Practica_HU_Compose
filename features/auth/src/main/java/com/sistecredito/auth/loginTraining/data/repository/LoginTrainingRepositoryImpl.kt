package com.sistecredito.auth.loginTraining.data.repository

import com.sistecredito.auth.loginTraining.data.remote.LoginTrainingApi
import com.sistecredito.auth.loginTraining.data.remote.dto.LoginDto
import com.sistecredito.auth.loginTraining.data.remote.dto.TokenDto
import com.sistecredito.auth.loginTraining.domain.repository.LoginTrainigRepository
import javax.inject.Inject

class LoginTrainingRepositoryImpl @Inject constructor(private val api: LoginTrainingApi):LoginTrainigRepository{
    override suspend fun login(login: LoginDto): TokenDto {
       return api.login(login)
    }
}