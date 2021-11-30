package com.sistecredito.auth.serie.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResultsDto(
    @SerializedName("air_date")
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)