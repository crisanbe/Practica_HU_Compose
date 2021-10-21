package com.sistecredito.auth.presentation

import com.sistecredito.auth.domain.model.Data

data class DataState(
    val isLoading : Boolean = false,
    val data: Data? = null,
    val error: String = ""
)