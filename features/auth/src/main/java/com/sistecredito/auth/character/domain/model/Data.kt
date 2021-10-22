package com.sistecredito.auth.character.domain.model

import com.sistecredito.auth.character.data.remote.dto.Info
import com.sistecredito.auth.character.data.remote.dto.Result

data class Data(
    val info: Info,
    val results: List<Result>
)