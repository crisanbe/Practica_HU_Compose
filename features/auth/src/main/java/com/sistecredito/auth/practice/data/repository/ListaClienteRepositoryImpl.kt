package com.sistecredito.auth.practice.data.repository


import com.sistecredito.auth.practice.domain.repository.ListaClienteRepository
import com.sistecredito.auth.practice.data.remote.ListaClienteApi
import com.sistecredito.auth.practice.data.remote.dto.ListaClienteDto
import javax.inject.Inject

class ListaClienteRepositoryImpl @Inject constructor(private val Api: ListaClienteApi):
    ListaClienteRepository {
    override suspend fun doListaCliente(lista: ListaClienteDto) {
        return Api.doListaCliente(lista )
    }

}