package com.sistecredito.auth.loginTraining.domain.useCase

import com.sistecredito.auth.loginTraining.data.remote.dto.LoginDto
import com.sistecredito.auth.loginTraining.data.remote.dto.TokenDto
import com.sistecredito.auth.loginTraining.domain.repository.LoginTrainigRepository
import com.sistecredito.shared.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginTrainigUseCase @Inject constructor(private val repository: LoginTrainigRepository){

    operator fun invoke(login: LoginDto): Flow<Resource<TokenDto>> = flow {
        try {
            emit(Resource.Loading<TokenDto>())
            val token = repository.login(login)
            emit(Resource.Success<TokenDto>(token))
        }catch (e:HttpException){
            emit(Resource.Error<TokenDto>("Error type HttpExceptions"))
        }catch (e: IOException){
            emit(Resource.Error<TokenDto>("Error type exceptions"))
        }
    }
}