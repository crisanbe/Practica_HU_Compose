package com.sistecredito.auth.practice.data.repository


import com.sistecredito.auth.practice.domain.repository.CustomerRepository
import com.sistecredito.auth.practice.data.remote.CustomerApi
import com.sistecredito.auth.practice.data.remote.dto.CustomerDto
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(private val api: CustomerApi): CustomerRepository {
    override suspend fun doCustomer(): List<CustomerDto> {
        return api.doCustomer()
    }
}