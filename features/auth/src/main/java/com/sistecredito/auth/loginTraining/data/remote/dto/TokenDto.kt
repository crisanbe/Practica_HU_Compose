package com.sistecredito.auth.loginTraining.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("expires_in")
    val expiresIn: Int,
    val scope: String,
    @SerializedName("token_type")
    val tokenType: String
)