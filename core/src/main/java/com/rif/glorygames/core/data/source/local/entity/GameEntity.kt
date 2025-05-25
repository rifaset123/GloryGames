package com.rif.glorygames.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey
    val gameId: String,

    @field:ColumnInfo(name = "name")
    val name: String,

    @field:ColumnInfo(name = "release_date")
    val releaseDate: String? = null,

    @field:ColumnInfo(name = "rating")
    val rating: Double,

    @field:ColumnInfo(name = "playtime")
    val playtime: Double,

    @field:ColumnInfo(name = "rating_count")
    val ratingCount: Int,

    @field:ColumnInfo(name = "background_image")
    val backgroundImage: String,

    @field:ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
