package com.sistecredito.auth.practice.data.remote

import com.sistecredito.auth.practice.data.remote.dto.CustomerDto
import retrofit2.http.GET

interface CustomerApi {
    @GET("photos")
    suspend fun doCustomer(): List<CustomerDto>
}