package com.sistecredito.auth.login.data.repository

import com.sistecredito.auth.login.data.remote.LoginApi
import com.sistecredito.auth.login.data.remote.dto.LoginDto
import com.sistecredito.auth.login.data.remote.dto.TokenDto
import com.sistecredito.auth.login.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val api: LoginApi):LoginRepository {
    override suspend fun doLogin(login: LoginDto): TokenDto {
        return api.doLogin(login )
    }

}