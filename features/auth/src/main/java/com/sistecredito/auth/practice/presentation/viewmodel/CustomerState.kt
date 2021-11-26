package com.sistecredito.auth.practice.presentation.viewmodel


import com.sistecredito.auth.practice.data.remote.dto.CustomerDto

data class CustomerState (
    val isLoading : Boolean = false,
    val data: List<CustomerDto?> = emptyList(),
    val error: String = ""
)