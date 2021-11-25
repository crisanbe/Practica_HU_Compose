package com.sistecredito.auth.login.domain.usecase

import com.sistecredito.auth.login.data.remote.dto.LoginDto
import com.sistecredito.auth.login.data.remote.dto.TokenDto
import com.sistecredito.auth.login.domain.repository.LoginRepository
import com.sistecredito.auth.practice.data.remote.dto.ListaClienteDto
import com.sistecredito.auth.practice.domain.repository.ListaClienteRepository
import com.sistecredito.shared.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ListaClienteUseCase @Inject constructor(private val repository: ListaClienteRepository) {

    operator fun invoke(lista: ListaClienteDto){
        try{
            Resource.Loading(null)
            Resource.Success(lista)

        }catch (e:HttpException){
            Resource.Error<TokenDto>(e.localizedMessage ?: "An unexpected error ocurred")
        }catch (e: IOException){
            Resource.Error<TokenDto>("Couldn't reach server. Check you internet connection")
        }
    }
}