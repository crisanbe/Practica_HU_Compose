package com.sistecredito.auth.character.data.repository

import com.sistecredito.auth.character.data.remote.ServiceApi
import com.sistecredito.auth.character.data.remote.dto.DataDto
import com.sistecredito.auth.character.domain.repository.ServiceRepository
import javax.inject.Inject

class ServiceRepositoryImpl @Inject constructor(private val api: ServiceApi): ServiceRepository {
    override suspend fun getAll(): DataDto {
        return api.getAll()
    }

}