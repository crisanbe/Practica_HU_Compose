package com.sistecredito.auth.login.domain.usecase

import com.sistecredito.auth.login.data.remote.dto.LoginDto
import com.sistecredito.auth.login.data.remote.dto.TokenDto
import com.sistecredito.auth.login.data.remote.dto.toToken
import com.sistecredito.auth.login.domain.model.Token
import com.sistecredito.auth.login.domain.repository.LoginRepository
import com.sistecredito.shared.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LogInUseCase @Inject constructor(private val repository: LoginRepository) {

    operator fun invoke(login: LoginDto): Flow<Resource<TokenDto>> = flow {
        try{
            emit(Resource.Loading<TokenDto>())
            val token = repository.doLogin(login = login)
            emit(Resource.Success<TokenDto>(token))

        }catch (e:HttpException){
            emit(Resource.Error<TokenDto>(e.localizedMessage ?: "An unexpected error ocurred"))
        }catch (e: IOException){
            emit(Resource.Error<TokenDto>("Couldn't reach server. Check you internet connection"))
        }
    }
}