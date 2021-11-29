package com.sistecredito.auth.serie.domain.model

import com.sistecredito.auth.serie.data.remote.dto.ResultsDto


data class Serie(
    val info: Info,
    val results: List<ResultsDto>
)