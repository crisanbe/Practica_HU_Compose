package com.sistecredito.auth.login.domain.model

data class Token(
    val accessToken: String,
    val expiresIn: Int,
    val scope: String,
    val tokenType: String
)
