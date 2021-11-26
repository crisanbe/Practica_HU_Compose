package com.sistecredito.auth.practice.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CustomerDto(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)