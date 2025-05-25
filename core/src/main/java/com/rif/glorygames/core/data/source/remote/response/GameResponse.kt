package com.rif.glorygames.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GameResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("released")
    val releaseDate: String,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("playtime")
    val playtime: Double,

    @field:SerializedName("ratings_count")
    val ratingCount: Int,

    @field:SerializedName("background_image")
    val backgroundImage: String
)

