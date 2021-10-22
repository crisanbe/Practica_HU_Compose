package com.sistecredito.auth.character.data.remote.dto

import com.sistecredito.auth.character.domain.model.Data

data class DataDto(
    val info: Info,
    val results: List<Result>
)

fun DataDto.toCharacter(): Data {
    return Data(
        info = info,
        results = results
    )
}