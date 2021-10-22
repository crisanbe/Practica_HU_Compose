package com.sistecredito.auth.login.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.sistecredito.auth.login.domain.model.Token


data class TokenDto(
    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("expires_in")
    val expiresIn: Int,

    @SerializedName("scope")
    val scope: String,

    @SerializedName("token_type")
    val tokenType: String
)

fun TokenDto.toToken(): Token {
    return Token(
        accessToken = accessToken,
        expiresIn = expiresIn,
        scope = scope,
        tokenType = tokenType
    )
}