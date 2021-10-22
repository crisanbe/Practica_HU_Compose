package com.sistecredito.auth.login.domain.model

import com.google.gson.annotations.SerializedName

class Login(
    val clientId: String,
    val password: String,
    val username: String
)