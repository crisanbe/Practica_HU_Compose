package com.sistecredito.auth.login.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("client_id")
    val clientId: String,

    @SerializedName("password")
    val password: String,

    @SerializedName("username")
    val username: String
)