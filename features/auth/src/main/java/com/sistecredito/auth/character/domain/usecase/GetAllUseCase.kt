package com.sistecredito.auth.character.domain.usecase

import com.sistecredito.auth.character.data.remote.dto.toCharacter
import com.sistecredito.auth.character.domain.model.Data
import com.sistecredito.auth.character.domain.repository.ServiceRepository
import com.sistecredito.shared.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllUseCase  @Inject constructor(private val repository: ServiceRepository){

    operator fun invoke(): Flow<Resource<Data>> = flow {
        try {
            emit(Resource.Loading<Data>())
            val characters = repository.getAll().toCharacter()
            emit(Resource.Success<Data>(characters))
        }catch (e : HttpException){
            emit(Resource.Error<Data>(e.localizedMessage?:"An unexpected error ocurred"))
        }catch (e: IOException){
            emit(Resource.Error<Data>("Couldn't reach server. Check you internet connection"))
        }
    }

}