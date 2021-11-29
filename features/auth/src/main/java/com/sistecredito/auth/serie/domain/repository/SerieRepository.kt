package com.sistecredito.auth.serie.domain.repository




import com.sistecredito.auth.serie.data.remote.dto.ResultsDto
import com.sistecredito.auth.serie.data.remote.dto.SerieDto


interface SerieRepository {
    suspend fun doSerie(): SerieDto


}
