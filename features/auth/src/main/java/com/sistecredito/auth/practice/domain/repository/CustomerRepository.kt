package com.sistecredito.auth.practice.domain.repository


import com.sistecredito.auth.practice.data.remote.dto.CustomerDto


interface CustomerRepository {
    suspend fun doCustomer(): List<CustomerDto>
}