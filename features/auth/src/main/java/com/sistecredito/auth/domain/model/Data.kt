package com.sistecredito.auth.domain.model

import com.sistecredito.auth.data.remote.dto.Info
import com.sistecredito.auth.data.remote.dto.Result

data class Data(
    val info: Info,
    val results: List<Result>
)