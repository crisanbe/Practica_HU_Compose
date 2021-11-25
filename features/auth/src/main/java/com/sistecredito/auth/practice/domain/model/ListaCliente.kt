package com.sistecredito.auth.practice.domain.model

import com.google.gson.annotations.SerializedName

data class ListaCliente(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)