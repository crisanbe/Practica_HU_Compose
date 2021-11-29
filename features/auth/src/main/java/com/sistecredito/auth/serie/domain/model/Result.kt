package com.sistecredito.auth.serie.domain.model

import com.google.gson.annotations.SerializedName

data class Result(
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)