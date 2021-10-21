package com.sistecredito.auth.domain.repository

import com.sistecredito.auth.data.remote.dto.DataDto

interface ServiceRepository {
    suspend fun getAll(): DataDto
}