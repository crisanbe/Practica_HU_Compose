package com.sistecredito.auth.serie.domain.repository




import com.sistecredito.auth.serie.data.remote.dto.ResultsDto


interface SerieRepository {
    suspend fun doSerie(): List<ResultsDto>
}