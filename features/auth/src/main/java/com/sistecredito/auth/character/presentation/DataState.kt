package com.sistecredito.auth.character.presentation

import com.sistecredito.auth.character.domain.model.Data

data class DataState(
    val isLoading : Boolean = false,
    val data: Data? = null,
    val error: String = ""
)