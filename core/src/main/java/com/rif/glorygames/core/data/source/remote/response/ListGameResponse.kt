package com.rif.glorygames.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListGameResponse(

    @field:SerializedName("count")
    val error: Int,

    @field:SerializedName("next")
    val message: String,

    @field:SerializedName("previous")
    val previous: String,

    @field:SerializedName("results")
    val results: List<GameResponse>
)