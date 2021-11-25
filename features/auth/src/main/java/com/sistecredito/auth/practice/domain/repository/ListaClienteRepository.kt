package com.sistecredito.auth.practice.domain.repository


import com.sistecredito.auth.practice.data.remote.dto.ListaClienteDto


interface ListaClienteRepository {
    suspend fun doListaCliente(lista: ListaClienteDto)
}