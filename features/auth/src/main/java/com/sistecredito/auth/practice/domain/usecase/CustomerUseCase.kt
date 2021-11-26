package com.sistecredito.auth.practice.domain.usecase


import com.sistecredito.auth.practice.data.remote.dto.CustomerDto
import com.sistecredito.auth.practice.domain.repository.CustomerRepository
import com.sistecredito.shared.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CustomerUseCase @Inject constructor(private val repository: CustomerRepository) {

    operator fun invoke(): Flow<Resource<List<CustomerDto>>> = flow{
        try{
            Resource.Loading<List<CustomerDto>>()
            val listcustomer = repository.doCustomer()
            Resource.Success<List<CustomerDto>>(listcustomer)

        }catch (e:HttpException){
            Resource.Error<List<CustomerDto>>(e.localizedMessage ?: "An unexpected error ocurred")
        }catch (e: IOException){
            Resource.Error<List<CustomerDto>>("Couldn't reach server. Check you internet connection")
        }
    }
}