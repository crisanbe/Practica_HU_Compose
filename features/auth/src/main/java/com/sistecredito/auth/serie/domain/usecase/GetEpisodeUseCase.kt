package com.sistecredito.auth.serie.domain.usecase


import com.sistecredito.auth.productos.data.remote.dto.ResultDto
import com.sistecredito.auth.serie.data.remote.dto.ResultsDto
import com.sistecredito.auth.serie.data.remote.dto.SerieDto
import com.sistecredito.auth.serie.domain.repository.SerieRepository
import com.sistecredito.shared.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

    class GetEpisodeUseCase @Inject constructor(private val repository: SerieRepository) {

    operator fun invoke(id: String): Flow<Resource<ResultsDto>> = flow {
        try {
            emit(Resource.Loading<ResultsDto>())
            val Result = repository.getEpisodeById(id)
            emit(Resource.Success<ResultsDto>(Result))

        } catch (e: HttpException) {
            emit(Resource.Error<ResultsDto>(e.localizedMessage ?: "An unexpected error ocurred"))
        } catch (e: IOException) {
            emit(Resource.Error<ResultsDto>("Couldn't reach server. Check you internet connection"))
        }
    }
}