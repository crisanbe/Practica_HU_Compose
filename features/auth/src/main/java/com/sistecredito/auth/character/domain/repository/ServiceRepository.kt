package com.sistecredito.auth.character.domain.repository

import com.sistecredito.auth.character.data.remote.dto.DataDto

interface ServiceRepository {
    suspend fun getAll(): DataDto
}