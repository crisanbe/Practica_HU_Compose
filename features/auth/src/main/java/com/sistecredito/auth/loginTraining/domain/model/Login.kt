package com.sistecredito.auth.loginTraining.domain.model

import com.google.gson.annotations.SerializedName

data class Login(
    val clientId: String,
    val password: String,
    val username: String
)