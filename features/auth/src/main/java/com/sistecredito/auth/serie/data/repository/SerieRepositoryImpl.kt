package com.sistecredito.auth.serie.data.repository



import com.sistecredito.auth.serie.data.remote.SerieApi
import com.sistecredito.auth.serie.data.remote.dto.ResultsDto
import com.sistecredito.auth.serie.data.remote.dto.SerieDto
import com.sistecredito.auth.serie.domain.repository.SerieRepository
import javax.inject.Inject

class SerieRepositoryImpl @Inject constructor(private val api: SerieApi): SerieRepository {

    override suspend fun doSerie(): SerieDto {
      return  api.doSerie()
    }

    override suspend fun getEpisodeById(id: String): ResultsDto {
        return api.getEpisodeById(id)
    }

}