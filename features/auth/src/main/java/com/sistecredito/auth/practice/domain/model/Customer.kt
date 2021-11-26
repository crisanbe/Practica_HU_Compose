package com.sistecredito.auth.practice.domain.model


data class Customer(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)