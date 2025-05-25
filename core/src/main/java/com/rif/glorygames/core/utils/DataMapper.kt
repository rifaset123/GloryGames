package com.rif.glorygames.core.utils

import com.rif.glorygames.core.data.source.local.entity.GameEntity
import com.rif.glorygames.core.data.source.remote.response.GameResponse
import com.rif.glorygames.core.domain.model.Game

object DataMapper {
    fun mapResponsesToEntities(input: List<GameResponse>): List<GameEntity> {
        val gameList = ArrayList<GameEntity>()
        input.map {
            val game =
                GameEntity(
                    gameId = it.id,
                    name = it.name,
                    releaseDate = it.releaseDate,
                    rating = it.rating,
                    playtime = it.playtime,
                    ratingCount = it.ratingCount,
                    backgroundImage = it.backgroundImage,
                    isFavorite = false
                )
            gameList.add(game)
        }
        return gameList
    }

    fun mapEntitiesToDomain(input: List<GameEntity>): List<Game> =
        input.map {
            Game(
                gameId = it.gameId,
                name = it.name,
                releaseDate = it.releaseDate ?: "To Be Announced",
                rating = it.rating,
                playtime = it.playtime,
                ratingCount = it.ratingCount,
                backgroundImage = it.backgroundImage,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Game) =
        GameEntity(
            gameId = input.gameId,
            name = input.name,
            releaseDate = input.releaseDate,
            rating = input.rating,
            playtime = input.playtime,
            ratingCount = input.ratingCount,
            backgroundImage = input.backgroundImage,
            isFavorite = input.isFavorite
        )
}