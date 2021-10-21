package com.sistecredito.auth.data.repository

import com.sistecredito.auth.data.remote.ServiceApi
import com.sistecredito.auth.data.remote.dto.DataDto
import com.sistecredito.auth.domain.repository.ServiceRepository
import javax.inject.Inject

class ServiceRepositoryImpl @Inject constructor(private val api:ServiceApi): ServiceRepository{
    override suspend fun getAll(): DataDto {
        return api.getAll()
    }

}