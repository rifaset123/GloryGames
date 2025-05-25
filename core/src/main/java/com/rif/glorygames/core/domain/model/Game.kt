package com.rif.glorygames.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val gameId: String,
    val name: String,
    val releaseDate: String,
    val rating: Double,
    val playtime: Double,
    val ratingCount: Int,
    val backgroundImage: String,
    val isFavorite: Boolean
) : Parcelable