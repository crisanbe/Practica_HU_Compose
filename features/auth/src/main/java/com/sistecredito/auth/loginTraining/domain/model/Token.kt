package com.sistecredito.auth.loginTraining.domain.model

import com.google.gson.annotations.SerializedName

data class Token(
    val accessToken: String,
    val expiresIn: Int,
    val scope: String,
    val tokenType: String
)