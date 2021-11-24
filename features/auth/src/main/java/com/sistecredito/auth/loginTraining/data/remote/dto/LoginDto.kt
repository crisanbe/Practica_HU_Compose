package com.sistecredito.auth.loginTraining.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("client_id")
    val clientId: String,
    val password: String,
    val username: String
)